package malte.Logic;

import java.util.ArrayList;
import java.util.List;
import malte.Data.entities.BOM;
import malte.Data.entities.Order;
import malte.Data.entities.Row;
import malte.Data.entities.Side;

/**
 * Bill of Materials. (Stykliste).
 *
 *
 * @author Malte
 */
class BOMLogic
{

    BOMLogic()
    {
    }

    /**
     * get Bill of Materials method.
     *
     * @return Bill of Materials.
     */
    BOM getBOM(Order order)
    {
        return makeBOM(order);
    }

    /**
     * Makes a single side of a house.
     *
     * @param height of Side.
     * @param length of Side.
     * @param hasDoor Does it have a door
     * @param hasWindow Does it have a window
     * @return
     */
    private Side getSide(int height, int length, boolean hasDoor, boolean hasWindow)
    {
        Side side = setside(height, hasDoor, hasWindow);
        makerows(height, hasDoor, hasWindow, length, side);
        setbricks(side);
        return side;
    }

    /**
     * Makes a single Row of bricks. A side consists of Height X Rows of bricks.
     * A House consists of 4 sides.
     *
     * @param length Has to be at least 8. Maybe 10. We'll see.
     * @return a Row
     */
    private Row getRow(int length)
    {
        Row row = new Row();

        if (length >= 4)
        {
            /* Fours */
            int fours = length / 4;
            row.setFours(fours);
            length %= 4;
        }
        /* Twos */
        if (length >= 2)
        {
            int twos = length / 2;
            row.setTwos(twos);
            length %= 2;
        }
        /* Ones */
        if (length >= 1)
        {
            int ones = length;
            row.setOnes(ones);
        }
        return row;
    }

    /**
     * Make all the Rows for One side of the House.
     *
     * @param height of the Rows
     * @param hasDoor does the side have a door or not
     * @param hasWindow does the side have a window or not
     * @param length length of the side
     * @param side Side object.
     */
    private void makerows(int height, boolean hasDoor, boolean hasWindow, int length, Side side)
    {
        // We need to add as many rows as there is height to a side.
        for (int i = 3; i < height + 3; i++)
        {
            if (!hasDoor && !hasWindow) // If its the wide side
            {
                normalrow(i, length, side);

            } else if (hasDoor) // If its the Door-side
            {
                door(i, length, side);

            } else if (hasWindow)
            {
                window(i, length, side);
            }
        }
    }

    /**
     * Prepare a side. Sets its values.
     *
     * @param height height of the side.
     * @param hasDoor does the side have a door or not
     * @param hasWindow does the side have a window or not
     * @return Side object.
     */
    private Side setside(int height, boolean hasDoor, boolean hasWindow)
    {
        Side side = new Side();
        side.setHeight(height);
        side.setDoor(hasDoor);
        side.setWindow(hasWindow);
        return side;
    }

    /**
     * Make the door side.
     *
     * @param i height
     * @param length of the door side
     * @param side the side it is on
     */
    private void door(int i, int length, Side side)
    {
        if (i <= 5) // If we're at the door part.
        {
            doorOrWindowRow(i, length, side);
        } else // If we're above the door
        {
            dwnormalrow(i, length, side);
        }
    }

    /**
     * Make the window side.
     *
     * @param i current height
     * @param length of the side
     * @param side that this row is on
     */
    private void window(int i, int length, Side side)
    {
        if (i == 4 || i == 5)
        {
            doorOrWindowRow(i, length, side);
        } else // If we're above or below the window.
        {
            dwnormalrow(i, length, side);
        }
    }

    /**
     * Set the bricks on the Row.
     *
     * @param side that this row is on.
     */
    private void setbricks(Side side)
    {
        int ones = 0;
        int twos = 0;
        int fours = 0;
        for (Row row : side.getRows())
        {
            ones += row.getOnes();
            twos += row.getTwos();
            fours += row.getFours();
        }
        side.setOnes(ones);
        side.setTwos(twos);
        side.setFours(fours);
    }

    /**
     * Door or window normal row. Door or window are on the length. So its the
     * opposite side that has to be short, compared to the width sides.
     *
     * @param i height
     * @param length of the side
     * @param side it belongs to
     */
    private void dwnormalrow(int i, int length, Side side)
    {
        Row row;
        // If its an uneven row.
        if (i % 2 == 1)
        {
            row = getRow(length);
        } else // If its an even row.
        {
            row = getRow(length - 4);
        }
        side.add(row);
    }

    /**
     * Help Method for getSide. Make a door or window row and add it to the
     * side.
     *
     * @param i height
     * @param length of the side
     * @param side it belongs to
     */
    private void doorOrWindowRow(int i, int length, Side side)
    {
        for (int y = 0; y < 2; y++) // We need bricks on both side of the element.
        {
            int doorlength = length / 2;
            if (i % 2 == 1) // If its an uneven row
            {
                doorlength -= 2;

            } else // It its an even row.
            {
                doorlength -= 4;
            }
            Row row = getRow(doorlength);
            side.add(row);
        }
    }

    /**
     * Help method for getSide. For width sides. Makes a row and adds it to the
     * side.
     *
     * @param i height
     * @param length of the side
     * @param side it belongs to
     */
    private void normalrow(int i, int length, Side side)
    {
        Row row;
        // If its an uneven row.
        if (i % 2 == 1)
        {
            row = getRow(length - 4);
        } else // If its an even row.
        {
            row = getRow(length);
        }
        side.add(row);
    }

    /**
     * Makes the BOM itself. Makes the 4 sides and puts them on the BOM and puts
     * the totals on the BOM.
     *
     * @param order you want made into a Bill of Materials.
     * @return Bill of Materials.
     */
    private BOM makeBOM(Order order)
    {
        int height = order.getHeight();
        int width = order.getWidth();
        int length = order.getLength();
        Side door = getSide(height, length, true, false);
        Side wide = getSide(height, width, false, false);
        Side window = getSide(height, length, false, true);
        List<Side> sides = new ArrayList<>();
        sides.add(door);
        sides.add(wide);
        sides.add(wide);
        sides.add(window);
        int totalones = 0;
        int totaltwos = 0;
        int totalfours = 0;
        for (Side side : sides)
        {
            totalones += side.getOnes();
            totaltwos += side.getTwos();
            totalfours += side.getFours();
        }
        BOM bom = setBom(door, wide, window, totalones, totaltwos, totalfours);
        return bom;
    }

    /**
     * Set all the values of the BOM.
     *
     * @param door side
     * @param wide side
     * @param window side
     * @param totalones amount of 2x1 bricks
     * @param totaltwos amount of 2x2 bricks
     * @param totalfours amount of 2x4 bricks
     * @return Bill of Materials object.
     */
    private BOM setBom(Side door, Side wide, Side window, int totalones, int totaltwos, int totalfours)
    {
        BOM bom = new BOM();
        bom.setDoor(door);
        bom.setWide(wide);
        bom.setWindow(window);
        bom.setTotalones(totalones);
        bom.setTotaltwos(totaltwos);
        bom.setTotalfours(totalfours);
        return bom;
    }

}

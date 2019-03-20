/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.FunctionLayer;

import java.util.ArrayList;
import java.util.List;
import malte.entities.BOM;
import malte.entities.Order;
import malte.entities.Row;
import malte.entities.Side;

/**
 *
 * @author Malte
 */
class BOMLogic
{

    /**
     * Makes a single Row of bricks. A side consists of Height X Rows of bricks.
     * A House consists of 4 sides.
     *
     * @param length Has to be at least 8. Maybe 10. We'll see.
     * @return
     */
    private Row getRow(int length)
    {
        Row row = new Row();
        
        if (length >= 4)
        {
            /* Fours */
            int fours = length / 4;
            row.setFours(fours);
            length = length % 4;
        }
        /* Twos */
        if (length >= 2)
        {
            int twos = length / 2;
            row.setTwos(twos);
            length = length % 2;
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
     * Makes a single side of a house.
     *
     * @param height
     * @param length
     * @param hasDoor
     * @param hasWindow
     * @return
     */
    private Side getSide(int height, int length, boolean hasDoor, boolean hasWindow)
    {
        Side side = new Side();
        side.setHeight(height);
        side.setDoor(hasDoor);
        side.setWindow(hasWindow);
        // We need to add as many rows as there is height to a side.
        for (int i = 3; i < height + 3; i++)
        {
            if (!hasDoor && !hasWindow) // If its the wide side
            {
                normalrow(i, length, side);
                
            } else if (hasDoor) // If its the Door-side
            {
                if (i <= 5) // If we're at the door part.
                {
                    doorOrWindowRow(i, length, side);
                } else // If we're above the door
                {
                    dwnormalrow(i, length, side);
                }
                
            } else if (hasWindow)
            {
                if (i == 4 || i == 5)
                {
                    doorOrWindowRow(i, length, side);
                } else // If we're above or below the window.
                {
                    dwnormalrow(i, length, side);
                }
            }
        }
        return side;
    }

    /**
     * Door or window normal row. Door or window are on the length. So its the
     * opposite side that has to be short, compared to the width sides.
     *
     * @param i
     * @param length
     * @param side
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
     * Help Method for getSide.
     *
     * @param i
     * @param length
     * @param side
     */
    private void doorOrWindowRow(int i, int length, Side side)
    {
        for (int y = 0; y < 2; y++) // We need bricks on both side of the element.
        {
            int doorlength = length / 2;
            if (i % 2 == 1) // If its an uneven row
            {
                doorlength = doorlength - 2;
                
            } else // It its an even row.
            {
                doorlength = doorlength - 4;
            }
            Row row = getRow(doorlength);
            side.add(row);
        }
    }

    /**
     * Help method for getSide. For width sides.
     *
     * @param i
     * @param length
     * @param side
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
    
    BOMLogic()
    {
    }

    /**
     * get Bill of Materials method.
     *
     * @param length
     * @param width
     * @param height
     * @return
     */
    BOM getBOM(Order order)
    {
        int height = order.getHeight();
        int width = order.getWidth();
        int length = order.getLength();
        BOM bom = new BOM();
        Side door = getSide(height, length, true, false);
        Side wide = getSide(height, width, false, false);
        Side window = getSide(height, length, false, true);
        List<Side> sides = new ArrayList<>();
        sides.add(wide);
        sides.add(wide);
        sides.add(door);
        sides.add(window);
        bom.setDoor(door);
        bom.setWide(wide);
        bom.setWindow(window);
        bom.setSides(sides);
        bom.setTotalFours();
        bom.setTotalOnes();
        bom.setTotalTwos();
        return bom;
    }
    
}

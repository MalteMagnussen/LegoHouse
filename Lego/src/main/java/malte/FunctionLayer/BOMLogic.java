/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.FunctionLayer;

import malte.entities.Row;
import malte.entities.Side;

/**
 *
 * @author Malte
 */
public class BOMLogic
{

    /**
     * Makes a single Row of bricks. A side consists of Height X Rows of bricks.
     * A House consists of 4 sides.
     *
     *
     * @param length Has to be at least 8. Maybe 10. We'll see.
     * @return
     */
    private Row getRow(int length)
    {
        Row row = new Row();

        /* Fours */
        int fours = length / 4;
        row.setFours(fours);
        length = length % 4;

        /* Twos */
        if (length >= 2)
        {
            int twos = length / 2;
            row.setTwos(twos);
            length = length % 2;

            /* Ones */
            if (length >= 1)
            {
                int ones = length;
                row.setOnes(ones);
            }
        }

        return row;
    }

    private Side getSide(int height, int length, boolean hasDoor, boolean hasWindow)
    {
        Side side = new Side();
        side.setHeight(height);
        side.setDoor(hasDoor);
        side.setWindow(hasWindow);

        if (!hasDoor && !hasWindow)
        {
            for (int i = 3; i < length + 3; i++)
            {
                Row row;
                if (i % 2 == 1)
                {
                    row = getRow(length - 4);
                } else
                {
                    row = getRow(length);
                }
                side.add(row);
            }
        } else if (hasDoor)
        {
            
        } else if (hasWindow)
        {

        }

        return side;
    }

    public BOMLogic()
    {
    }

}

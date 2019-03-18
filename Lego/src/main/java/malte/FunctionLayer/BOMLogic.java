/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.FunctionLayer;

import malte.entities.Row;

/**
 *
 * @author Malte
 */
public class BOMLogic
{
    /**
     * Makes a single Row of bricks.
     * A side consists of Height X Rows of bricks.
     * A House consists of 4 sides.
     * 
     * 
     * @param length Has to be at least 8. Maybe 10. We'll see.
     * @return 
     */
    public Row getRow(int length)
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

    public BOMLogic()
    {
    }
    
    
    
}

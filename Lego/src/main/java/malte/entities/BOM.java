/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malte
 */
public class BOM
{

    private List<Side> sides = new ArrayList<>();
    private int height;

    public BOM()
    {
    }

    public int getTotalFours(){
        int fours = 0;
        for (Side side: sides){
            fours += side.getFours();
        }
        return fours;
    }
    
    public int getTotalTwos(){
        int twos = 0;
        for (Side side: sides){
            twos += side.getTwos();
        }
        return twos;
    }
    
    public int getTotalOnes(){
        int ones = 0;
        for (Side side: sides){
            ones += side.getOnes();
        }
        return ones;
    }
    
    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    public List<Side> getSides()
    {
        return sides;
    }

    public void setSides(List<Side> sides)
    {
        this.sides = sides;
    }

}

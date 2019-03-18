/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.entities;

import java.util.List;

/**
 *
 * @author Malte
 */
public class BOM
{

    private List<Side> sides;
    private int height;

    public BOM()
    {
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

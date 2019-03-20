/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malte
 */
public class BOM implements Serializable
{

    // Fields
    private Side door;
    private List<Side> sides = new ArrayList<>();

    /**
     * Get the value of door
     *
     * @return the value of door
     */
    public Side getDoor()
    {
        return door;
    }

    /**
     * Set the value of door
     *
     * @param door new value of door
     */
    public void setDoor(Side door)
    {
        this.door = door;
    }

    private Side window;

    /**
     * Get the value of window
     *
     * @return the value of window
     */
    public Side getWindow()
    {
        return window;
    }

    /**
     * Set the value of window
     *
     * @param window new value of window
     */
    public void setWindow(Side window)
    {
        this.window = window;
    }

    private Side wide;

    /**
     * Get the value of wide
     *
     * @return the value of wide
     */
    public Side getWide()
    {
        return wide;
    }

    /**
     * Set the value of wide
     *
     * @param wide new value of wide
     */
    public void setWide(Side wide)
    {
        this.wide = wide;
    }

    private int height;

    /**
     * Constructor.
     */
    public BOM()
    {
    }

    /**
     * Get the amount of 4x2 bricks for this Bill of Materials.
     *
     * @return
     */
    public int getTotalFours()
    {
        int fours = 0;
        for (Side side : sides)
        {
            fours += side.getFours();
        }
        return fours;
    }

    /**
     * Get the amount of 2x2 bricks for this Bill of Materials.
     *
     * @return
     */
    public int getTotalTwos()
    {
        int twos = 0;
        for (Side side : sides)
        {
            twos += side.getTwos();
        }
        return twos;
    }

    /**
     * Get the amount of 1x2 bricks for this Bill of Materials.
     *
     * @return
     */
    public int getTotalOnes()
    {
        int ones = 0;
        for (Side side : sides)
        {
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

    /**
     * Returns the 4 sides of the building.
     *
     * @return
     */
    public List<Side> getSides()
    {
        return sides;
    }

    /**
     * Set the 4 sides of the building.
     *
     * @param sides
     */
    public void setSides(List<Side> sides)
    {
        this.sides = sides;
    }

}

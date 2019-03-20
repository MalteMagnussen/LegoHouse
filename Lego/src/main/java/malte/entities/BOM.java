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
    private int height, totalones, totaltwos, totalfours;

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

    /**
     * Constructor.
     */
    public BOM()
    {
    }

    /**
     * Get the amount of 4x2 bricks for this Bill of Materials.
     *
     */
    public void setTotalFours()
    {
        for (Side side : sides)
        {
            totalfours += side.getFours();
        }
    }

    /**
     * Get the amount of 2x2 bricks for this Bill of Materials.
     *
     */
    public void setTotalTwos()
    {
        for (Side side : sides)
        {
            totaltwos += side.getTwos();
        }
    }

    /**
     * Get the amount of 1x2 bricks for this Bill of Materials.
     *
     */
    public void setTotalOnes()
    {
        for (Side side : sides)
        {
            totalones += side.getOnes();
        }
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

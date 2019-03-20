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
public class Side implements Serializable
{

    // Fields
    private List<Row> rows = new ArrayList<>();
    private boolean window;
    private boolean door;
    private int height, ones, twos, fours;

    public int getOnes()
    {
        return ones;
    }

    public void setOnes(int ones)
    {
        this.ones = ones;
    }

    public int getTwos()
    {
        return twos;
    }

    public void setTwos(int twos)
    {
        this.twos = twos;
    }

    public int getFours()
    {
        return fours;
    }

    public void setFours(int fours)
    {
        this.fours = fours;
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
     * Get the value of door
     *
     * @return the value of door
     */
    public boolean hasDoor()
    {
        return door;
    }

    /**
     * Set the value of door
     *
     * @param door new value of door
     */
    public void setDoor(boolean door)
    {
        this.door = door;
    }

    /**
     * Get the value of window
     *
     * @return the value of window
     */
    public boolean hasWindow()
    {
        return window;
    }

    /**
     * Set the value of window
     *
     * @param window new value of window
     */
    public void setWindow(boolean window)
    {
        this.window = window;
    }

    /**
     * Constructor.
     */
    public Side()
    {
    }

    /**
     * Get the list of rows of this side.
     *
     * @return
     */
    public List<Row> getRows()
    {
        return rows;
    }

    /**
     * Set all the rows to this list of rows.
     *
     * @param rows
     */
    public void setRows(List<Row> rows)
    {
        this.rows = rows;
    }

    /**
     * Add row to the list.
     *
     * @param row
     */
    public void add(Row row)
    {
        this.rows.add(row);
    }

}

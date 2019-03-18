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
public class Side
{

    private List<Row> rows;
    private boolean window;
    private boolean door;

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

    public Side()
    {
    }

    public List<Row> getRows()
    {
        return rows;
    }

    public void setRows(List<Row> rows)
    {
        this.rows = rows;
    }

}

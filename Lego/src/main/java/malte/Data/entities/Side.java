package malte.Data.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Row entity class. Should fulfill bean standards.
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

    /**
     * Get number of 1x2 bricks on this side.
     *
     * @return total number of 1x2 bricks on this side.
     */
    public int getOnes()
    {
        return ones;
    }

    /**
     * Set the number of total 1x2 bricks on this side.
     *
     * @param ones number of total 1x2 bricks on this side.
     */
    public void setOnes(int ones)
    {
        this.ones = ones;
    }

    /**
     * Get number of 2x2 bricks on this side.
     *
     * @return total number of 2x2 bricks on this side.
     */
    public int getTwos()
    {
        return twos;
    }

    /**
     * Set the number of total 2x2 bricks on this side.
     *
     * @param twos number of total 2x2 bricks on this side.
     */
    public void setTwos(int twos)
    {
        this.twos = twos;
    }

    /**
     * Get number of 4x2 bricks on this side.
     *
     * @return total number of 4x2 bricks on this side.
     */
    public int getFours()
    {
        return fours;
    }

    /**
     * Set the number of total 4x2 bricks on this side.
     *
     * @param fours number of total 4x2 bricks on this side.
     */
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
     * @return List of rows.
     */
    public List<Row> getRows()
    {
        return rows;
    }

    /**
     * Set all the rows to this list of rows.
     *
     * @param rows A list of rows.
     */
    public void setRows(List<Row> rows)
    {
        this.rows = rows;
    }

    /**
     * Add row to the list.
     *
     * @param row A single row.
     */
    public void add(Row row)
    {
        this.rows.add(row);
    }

}

package malte.Data.entities;

import java.io.Serializable;

/**
 * Bill of Materials. Stykliste
 *
 * @author Malte
 */
public class BOM implements Serializable
{

    // Fields
    private Side door, window, wide;
    private int height, totalones, totaltwos, totalfours;

    /**
     * Get the number of ones
     *
     * @return the number of ones
     */
    public int getTotalones()
    {
        return totalones;
    }

    /**
     * Get the number of twos
     *
     * @return the number of twos
     */
    public int getTotaltwos()
    {
        return totaltwos;
    }

    /**
     * Get the number of fours
     *
     * @return the number of fours
     */
    public int getTotalfours()
    {
        return totalfours;
    }

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
     * Set the value of totalones.
     *
     * @param totalones the value of totalones
     */
    public void setTotalones(int totalones)
    {
        this.totalones = totalones;
    }

    /**
     * Set the value of totaltwos.
     *
     * @param totaltwos the value of totalones
     */
    public void setTotaltwos(int totaltwos)
    {
        this.totaltwos = totaltwos;
    }

    /**
     * Set the value of totalfours.
     *
     * @param totalfours the value of totalfours
     */
    public void setTotalfours(int totalfours)
    {
        this.totalfours = totalfours;
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

}

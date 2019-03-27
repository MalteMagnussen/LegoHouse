package Data.Entities;

import java.io.Serializable;

/**
 * Row entity class. Should fulfill bean standards.
 *
 * @author Malte
 */
public class Row implements Serializable
{

    // Fields
    private int fours;
    private int twos;
    private int ones;

    /**
     * Constructor.
     */
    public Row()
    {
    }

    /**
     * Get the value of ones
     *
     * @return the value of ones
     */
    public int getOnes()
    {
        return ones;
    }

    /**
     * Set the value of ones
     *
     * @param ones new value of ones
     */
    public void setOnes(int ones)
    {
        this.ones = ones;
    }

    /**
     * Get the value of fours
     *
     * @return the value of fours
     */
    public int getFours()
    {
        return fours;
    }

    /**
     * Set the value of fours
     *
     * @param fours new value of fours
     */
    public void setFours(int fours)
    {
        this.fours = fours;
    }

    /**
     * Get the value of twos
     *
     * @return the value of twos
     */
    public int getTwos()
    {
        return twos;
    }

    /**
     * Set the value of twos
     *
     * @param twos new value of twos
     */
    public void setTwos(int twos)
    {
        this.twos = twos;
    }

}

package Data.Entities;

import java.io.Serializable;

/**
 * Order Entity. Trying to fulfill the JavaBean standard
 *
 * @author Malte
 */
public class Order implements Serializable
{

    /**
     * Constructor.
     */
    public Order()
    {
    }

    /**
     * Fields.
     * IDorders is the ID of the User whose Order it is. Bad naming, I know.
     * id is the ID of the order.
     * Sorry.
     */
    private int length, width, height, idorders, id;
    private boolean sent;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Get the value of sent
     *
     * @return the value of sent
     */
    public boolean isSent()
    {
        return sent;
    }

    /**
     * Set the value of sent
     *
     * @param sent new value of sent
     */
    public void setSent(boolean sent)
    {
        this.sent = sent;
    }

    /**
     * Get the value of idorders
     *
     * @return the value of idorders
     */
    public int getIdorders()
    {
        return idorders;
    }

    /**
     * Set the value of idorders
     *
     * @param idorders new value of idorders
     */
    public void setIdorders(int idorders)
    {
        this.idorders = idorders;
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
     * Get the value of length
     *
     * @return the value of length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Set the value of length
     *
     * @param length new value of length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * Get the value of width
     *
     * @return the value of width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Set the value of width
     *
     * @param width new value of width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

}

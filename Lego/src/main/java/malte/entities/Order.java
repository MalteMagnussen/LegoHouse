/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.entities;

import java.io.Serializable;

/**
 * Order Entity. Trying to fulfill the JavaBean standard
 *
 * @author Malte
 */
public class Order implements Serializable {

    /**
     * Constructor.
     */
    public Order() {
    }

    /**
     * Fields.
     */
    private int length, width, height, idorders;
    private boolean sent;
    private String date;

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the value of sent
     *
     * @return the value of sent
     */
    public boolean isSent() {
        return sent;
    }

    /**
     * Set the value of sent
     *
     * @param sent new value of sent
     */
    public void setSent(boolean sent) {
        this.sent = sent;
    }

    /**
     * Get the value of idorders
     *
     * @return the value of idorders
     */
    public int getIdorders() {
        return idorders;
    }

    /**
     * Set the value of idorders
     *
     * @param idorders new value of idorders
     */
    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the value of length
     *
     * @return the value of length
     */
    public int getLength() {
        return length;
    }

    /**
     * Set the value of length
     *
     * @param length new value of length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Get the value of width
     *
     * @return the value of width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the value of width
     *
     * @param width new value of width
     */
    public void setWidth(int width) {
        this.width = width;
    }

}

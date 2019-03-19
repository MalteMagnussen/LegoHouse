/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malte
 */
public class Side
{

    private List<Row> rows = new ArrayList<>();
    private boolean window;
    private boolean door;
    private int height;
    
    public int getFours(){
        int fours = 0;
        for (Row row: rows){
            fours += row.getFours();
        }
        return fours;
    }
    
    public int getTwos(){
        int twos = 0;
        for (Row row: rows){
            twos += row.getTwos();
        }
        return twos;
    }
    
    public int getOnes(){
        int ones = 0;
        for (Row row: rows){
            ones += row.getOnes();
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

    public void add(Row row)
    {
        this.rows.add(row);
    }

}

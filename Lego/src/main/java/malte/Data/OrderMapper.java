/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import malte.Data.Exceptions.ShopException;
import malte.Data.entities.Order;
import malte.Data.entities.User;

/**
 * OrderDAO
 *
 * @author Malte
 */
class OrderMapper
{

    OrderMapper()
    {
    }

    /**
     * Called from LogicFacade createOrder Method.
     *
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     * @param order you want to insert into the database.
     */
    void createOrder(Order order) throws ShopException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (idorders, length, width, height) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getIdorders());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new ShopException(ex.getMessage());
        }
    }

    /**
     * Called from LogicFacade getOrders Method.
     *
     * @param user you want to get the orders from.
     * @return List of Orders.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    List<Order> getOrders(User user) throws ShopException
    {
        List<Order> orders = new ArrayList<>();
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT `orders`.`sent`,\n"
                    + "    `orders`.`length`,\n"
                    + "    `orders`.`width`,\n"
                    + "    `orders`.`height`,\n"
                    + "    `orders`.`id`\n"
                    + "FROM `useradmin`.`orders`\n"
                    + "WHERE `orders`.`idorders` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                boolean sent = rs.getBoolean("sent");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int id = rs.getInt("id");
                Order order = new Order();
                order.setHeight(height);
                order.setLength(length);
                order.setWidth(width);
                order.setSent(sent);
                order.setId(id);
                orders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new ShopException(ex.getMessage());
        }

        return orders;
    }

    /**
     * Get a single Order from its ID.
     *
     * @param id of the order you want to get.
     * @return the Order of the ID.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    Order getOrder(int id) throws ShopException
    {
        Order order = new Order();
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT `orders`.`sent`,\n"
                    + "    `orders`.`length`,\n"
                    + "    `orders`.`width`,\n"
                    + "    `orders`.`height`\n"
                    + "FROM `useradmin`.`orders`\n"
                    + "WHERE `orders`.`id` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                boolean sent = rs.getBoolean("sent");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                order.setHeight(height);
                order.setLength(length);
                order.setWidth(width);
                order.setSent(sent);
                order.setId(id);
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new ShopException(ex.getMessage());
        }
        return order;
    }

    /**
     * Mark order as being sent to customer. Usable by employee.
     *
     * @param id of the Order you wish to mark as sent.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    void sendOrder(int id) throws ShopException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "UPDATE useradmin.orders set sent = true WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new ShopException(ex.getMessage());
        }
    }

}

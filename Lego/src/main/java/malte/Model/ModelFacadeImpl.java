/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.Model;

import java.util.List;
import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;
import malte.Model.entities.Order;
import malte.Model.entities.User;

/**
 * Model Facade Impl
 *
 * @author Malte
 */
public class ModelFacadeImpl implements ModelFacade
{

    public ModelFacadeImpl()
    {
    }

    /**
     * Create User. Inputs a User into the Database
     *
     * @param user
     * @throws LoginException
     */
    @Override
    public void createUser(User user) throws LoginException
    {
        UserMapper db = new UserMapper();
        db.createUser(user);
    }

    /**
     * Login. Log a User into the system.
     *
     * @param email
     * @param password
     * @return
     * @throws LoginException
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public User login(String email, String password) throws LoginException, ShopException
    {
        UserMapper db = new UserMapper();
        return db.login(email, password);
    }

    /**
     * Get Orders. Get a list of Orders.
     *
     * @param user
     * @return
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public List<Order> getOrders(User user) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        return db.getOrders(user);
    }

    /**
     * Create an Order in the Database.
     *
     * @param order
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public void createOrder(Order order) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        db.createOrder(order);
    }

    /**
     * Get a List of All Users. Used by Employee.
     *
     * @return
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public List<User> getUsers() throws ShopException
    {
        UserMapper db = new UserMapper();
        return db.getUsers();
    }

    /**
     * Get an Order by ID.
     *
     * @param id
     * @return
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public Order getOrder(int id) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        return db.getOrder(id);
    }

    /**
     * Mark an order as sent in the database.
     *
     * @param id
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public void sendOrder(int id) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        db.sendOrder(id);
    }

}

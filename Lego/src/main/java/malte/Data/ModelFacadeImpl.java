/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.Data;

import java.util.List;
import malte.Data.Exceptions.LoginException;
import malte.Data.Exceptions.ShopException;
import malte.Data.entities.Order;
import malte.Data.entities.User;

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
     * @param user User you wish to input into SQL database.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
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
     * @param email of the user
     * @param password of the user
     * @return User object
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
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
     * @param user Object
     * @return List of all the Orders of this user.
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
     * @param order you wish to insert into the database.
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
     * @return a List of all users in the system.
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
     * @param id of the Order.
     * @return an order object.
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
     * @param id of the order.
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

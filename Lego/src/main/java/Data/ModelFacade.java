/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;
import Data.Exceptions.LoginException;
import Data.Exceptions.ShopException;
import Data.Entities.Order;
import Data.Entities.User;

/**
 * Model Facade Interface.
 *
 * @author Malte
 */
public interface ModelFacade
{

    /**
     * Create a User in the Database table.
     *
     * @param user User to create.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     */
    void createUser(User user) throws LoginException;

    /**
     * Login a User.
     *
     * @param email email of user.
     * @param password password of user.
     * @return User object.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    User login(String email, String password) throws LoginException, ShopException;

    /**
     * Get all Orders made by this User.
     *
     * @param user User you want orders from.
     * @return List of Orders from the User.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    List<Order> getOrders(User user) throws ShopException;

    /**
     * Create a single Order in the Database.
     *
     * @param order the one you want in the database.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    void createOrder(Order order) throws ShopException;

    /**
     * Get a list of all the Users in the system.
     *
     * @return a list of all users.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    List<User> getUsers() throws ShopException;

    /**
     * Get an Order in the system. By ID.
     *
     * @param id of the order.
     * @return Order object. With param id.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    Order getOrder(int id) throws ShopException;

    /**
     * Mark an Order as Sent.
     *
     * @param id of the order.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    void sendOrder(int id) throws ShopException;
}

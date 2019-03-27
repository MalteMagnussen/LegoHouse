/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;
import Data.Exceptions.LoginException;
import Data.Exceptions.ShopException;
import Data.entities.BOM;
import Data.entities.Order;
import Data.entities.User;

/**
 * Controller Facade Interface.
 *
 * @author Malte
 */
public interface ControllerFacade
{

    /**
     * Login a User.
     *
     * @param email of the User.
     * @param password of the User.
     * @return User object.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    User login(String email, String password) throws LoginException, ShopException;

    /**
     * Create a User.
     *
     * @param email of the User.
     * @param password of the User.
     * @return User object.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    User createUser(String email, String password) throws LoginException;

    /**
     * Create an Order.
     *
     * @param id of the User who made the Order.
     * @param length of the house.
     * @param width of the house.
     * @param height of the house.
     * @return Order object.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    Order createOrder(int id, int length, int width, int height) throws LoginException, ShopException;

    /**
     * Get all Orders from this User.
     *
     * @param user whose Orders you want. Usually only the User who is logged
     * in.
     * @return A List of all the Users Orders.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    List<Order> getOrders(User user) throws LoginException, ShopException;

    /**
     * Get all Users. But only if you're an employee.
     *
     * @param user Employee. Checks if User is employee. Throws error if he is
     * not.
     * @return List of all Users.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    List<User> getUsers(User user) throws LoginException, ShopException;

    /**
     * Get an Order by its ID.
     *
     * @param id of the Order.
     * @return the Order.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    Order getOrder(int id) throws LoginException, ShopException;

    /**
     * Mark an Order as sent.
     *
     * @param id of the Order you wish to send.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    void sendOrder(int id) throws LoginException, ShopException;

    /**
     * Get a Bill of Materials for an Order.
     *
     * @param order you wish to get a Bill of Materials for.
     * @return A Bill of Materials. (Stykliste)
     */
    BOM getBOM(Order order);
}

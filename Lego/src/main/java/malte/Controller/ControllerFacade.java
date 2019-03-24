/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.Controller;

import java.util.List;
import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;
import malte.Model.entities.BOM;
import malte.Model.entities.Order;
import malte.Model.entities.User;

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
     * @param email
     * @param password
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    User login(String email, String password) throws LoginException, ShopException;

    /**
     * Create a User.
     *
     * @param email
     * @param password
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     */
    User createUser(String email, String password) throws LoginException;

    /**
     * Create an Order.
     *
     * @param id
     * @param length
     * @param width
     * @param height
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    Order createOrder(int id, int length, int width, int height) throws LoginException, ShopException;

    /**
     * Get all Orders from this User.
     *
     * @param user
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    List<Order> getOrders(User user) throws LoginException, ShopException;

    /**
     * Get all Users.
     *
     * @param user
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    List<User> getUsers(User user) throws LoginException, ShopException;

    /**
     * Get an Order by its ID.
     *
     * @param id
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    Order getOrder(int id) throws LoginException, ShopException;

    /**
     * Mark an Order as sent.
     *
     * @param id
     * @throws LoginException Custom Exception. Caught in FrontController. Sends User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    void sendOrder(int id) throws LoginException, ShopException;

    /**
     * Get a Bill of Materials for an Order.
     *
     * @param order
     * @return
     */
    BOM getBOM(Order order);
}

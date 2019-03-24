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
 * Model Facade Interface.
 *
 * @author Malte
 */
public interface ModelFacade
{

    /**
     * Create a User in the Database table.
     *
     * @param user
     * @throws LoginException
     */
    void createUser(User user) throws LoginException;

    /**
     * Login a User.
     *
     * @param email
     * @param password
     * @return
     * @throws LoginException
     * @throws ShopException
     */
    User login(String email, String password) throws LoginException, ShopException;

    /**
     * Get all Orders made by this User.
     *
     * @param user
     * @return
     * @throws ShopException
     */
    List<Order> getOrders(User user) throws ShopException;

    /**
     * Create a single Order in the Database.
     *
     * @param order
     * @throws ShopException
     */
    void createOrder(Order order) throws ShopException;

    /**
     * Get a list of all the Users in the system.
     *
     * @return
     * @throws ShopException
     */
    List<User> getUsers() throws ShopException;

    /**
     * Get an Order in the system. By ID.
     *
     * @param id
     * @return
     * @throws ShopException
     */
    Order getOrder(int id) throws ShopException;

    /**
     * Mark an Order as Sent.
     *
     * @param id
     * @throws ShopException
     */
    void sendOrder(int id) throws ShopException;
}

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
 * Facade Interface.
 * 
 * @author Malte
 */
public interface ModelFacade
{
    void createUser(User user) throws LoginException;

    User login(String email, String password) throws LoginException, ShopException;

    List<Order> getOrders(User user) throws ShopException;

    void createOrder(Order order) throws ShopException;

    List<User> getUsers() throws ShopException;

    Order getOrder(int id) throws ShopException;

    void sendOrder(int id) throws ShopException;
}

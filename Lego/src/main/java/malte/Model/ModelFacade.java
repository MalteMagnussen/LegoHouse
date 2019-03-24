/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.Model;

import java.util.List;
import malte.Model.Exceptions.LoginException;
import malte.Model.entities.Order;
import malte.Model.entities.User;

/**
 * Facade Interface.
 * 
 * @author Malte
 */
public interface ModelFacade
{
    public void createUser(User user) throws LoginException;

    public User login(String email, String password);

    public List<Order> getOrders(User user);

    public Order createOrder(Order order);

    public List<User> getUsers();

    public Order getOrder(int id);

    public void sendOrder(int id);
}

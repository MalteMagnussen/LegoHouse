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
 *
 * @author Malte
 */
interface ControllerFacade
{
    User login(String email, String password) throws LoginException, ShopException;
    
    User createUser(String email, String password) throws LoginException;
    
    Order createOrder(int id, int length, int width, int height) throws LoginException, ShopException;
    
    List<Order> getOrders(User user) throws LoginException, ShopException;
    
    List<User> getUsers(User user) throws LoginException, ShopException;
    
    Order getOrder(int id) throws LoginException, ShopException;
    
    void sendOrder(int id) throws LoginException, ShopException;
    
    BOM getBOM(Order order);
}

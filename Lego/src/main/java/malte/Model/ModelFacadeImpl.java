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
 * Facade Impl
 * 
 * @author Malte
 */
public class ModelFacadeImpl implements ModelFacade
{

    public ModelFacadeImpl()
    {
    }
    
    @Override
    public void createUser(User user) throws LoginException
    {
        UserMapper db = new UserMapper();
        db.createUser(user);
    }

    @Override
    public User login(String email, String password) throws LoginException, ShopException
    {
        UserMapper db = new UserMapper();
        return db.login(email, password);
    }

    @Override
    public List<Order> getOrders(User user) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        return db.getOrders(user);
    }

    @Override
    public void createOrder(Order order) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        db.createOrder(order);
    }

    @Override
    public List<User> getUsers() throws ShopException
    {
        UserMapper db = new UserMapper();
        return db.getUsers();
    }

    @Override
    public Order getOrder(int id) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        return db.getOrder(id);
    }

    @Override
    public void sendOrder(int id) throws ShopException
    {
        OrderMapper db = new OrderMapper();
        db.sendOrder(id);
    }
    
}

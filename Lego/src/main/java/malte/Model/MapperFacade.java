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
 *
 * @author Malte
 */
public class MapperFacade implements ModelFacade
{

    public MapperFacade()
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
    public List<Order> getOrders(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order createOrder(Order order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUsers()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendOrder(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.Controller;

import malte.Model.OrderMapper;
import malte.Model.entities.Order;

/**
 * 
 * 
 * @author Malte
 */
class OrderLogic
{

    public OrderLogic()
    {
    }
    
    Order order(int id, int length, int width, int height) throws LoginException, ShopException
    {
        Order order = new Order();
        order.setIdorders(id);
        order.setLength(length);
        order.setWidth(width);
        order.setHeight(height);
        OrderMapper.createOrder(order);
        return order;
    }
}

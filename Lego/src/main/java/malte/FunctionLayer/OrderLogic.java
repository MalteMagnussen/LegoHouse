/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.FunctionLayer;

import malte.DBAccess.OrderMapper;
import malte.entities.Order;

/**
 *
 * @author Malte
 */
class OrderLogic
{

    public OrderLogic()
    {
    }
    
    Order order(int id, int length, int width, int height) throws CustomException
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

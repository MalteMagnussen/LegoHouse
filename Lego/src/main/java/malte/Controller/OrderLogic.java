package malte.Controller;

import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;
import malte.Model.ModelFacade;
import malte.Model.ModelFacadeImpl;
import malte.Model.entities.Order;

/**
 * Order Logic.
 *
 * @author Malte
 */
class OrderLogic
{

    public OrderLogic()
    {
    }

    /**
     * Make a new Order.
     *
     * @param id
     * @param length
     * @param width
     * @param height
     * @return
     * @throws LoginException
     * @throws ShopException
     */
    Order order(int id, int length, int width, int height) throws LoginException, ShopException
    {
        Order order = new Order();
        order.setIdorders(id);
        order.setLength(length);
        order.setWidth(width);
        order.setHeight(height);
        ModelFacade db = new ModelFacadeImpl();
        db.createOrder(order);
        return order;
    }
}

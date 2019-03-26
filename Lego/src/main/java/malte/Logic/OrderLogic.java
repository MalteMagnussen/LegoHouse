package malte.Logic;

import malte.Data.Exceptions.LoginException;
import malte.Data.Exceptions.ShopException;
import malte.Data.ModelFacade;
import malte.Data.ModelFacadeImpl;
import malte.Data.entities.Order;

/**
 * Order Logic.
 *
 * @author Malte
 */
class OrderLogic
{

    private static OrderLogic instance = null;

    public synchronized static OrderLogic getInstance()
    {
        if (instance == null)
        {
            instance = new OrderLogic();
        }
        return instance;
    }

    /**
     * Make a new Order.
     *
     * @param id of the User.
     * @param length of the LegoHouse.
     * @param width of the LegoHouse.
     * @param height of the LegoHouse.
     * @return an Order.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws ShopException Custom Exception. Caught in FrontController. Sends
     * User back to /WEB-INF/customerpage.jsp
     */
    Order order(int id, int length, int width, int height) throws LoginException, ShopException
    {
        Order order = new Order();
        order.setIdorders(id);
        order.setLength(length);
        order.setWidth(width);
        order.setHeight(height);
        ModelFacade db = ModelFacadeImpl.getInstance();
        db.createOrder(order);
        return order;
    }
}

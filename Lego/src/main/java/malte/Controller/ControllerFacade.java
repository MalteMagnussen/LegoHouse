package malte.Controller;

import java.util.List;
import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;
import malte.Model.OrderMapper;
import malte.Model.UserMapper;
import malte.Model.entities.BOM;
import malte.Model.entities.Order;
import malte.Model.entities.User;

/**
 * Facade Class.
 *
 * @author Malte
 */
public class ControllerFacade
{

    /**
     * User Login Facade.
     *
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException
     */
    public static User login(String email, String password) throws LoginException, ShopException
    {
        return UserMapper.login(email, password);
    }

    /**
     * Create User Facade.
     *
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws LoginException
     */
    public static User createUser(String email, String password) throws LoginException
    {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    /**
     * Create Order Facade.
     *
     * @param id Users ID
     * @param length LegoHouse Length
     * @param width LegoHouse Width
     * @param height LegoHouse Height
     * @return Order entity.
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException
     */
    public static Order createOrder(int id, int length, int width, int height) throws LoginException, ShopException
    {
        
        if (height < 4 || width < 5 || length < 8)
        {
            throw new ShopException("Too low width, height or length. Try again.");
        }
        return new OrderLogic().order(id, length, width, height);
        
    }

    /**
     * Get a List of all Orders for one User.
     *
     * @param user
     * @return
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException
     */
    public static List<Order> getOrders(User user) throws LoginException, ShopException
    {
        return OrderMapper.getOrders(user);
    }

    /**
     * Get all the users. Used by an employee.
     *
     * @param user The User who is logged in. Requires an Employee User for it
     * to work.
     * @return
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException
     */
    public static List<User> getUsers(User user) throws LoginException, ShopException
    {
        if (user.getRole().equals("employee"))
        {
            return UserMapper.getUsers();
        } else
        {
            throw new LoginException("Can't do this. You're not an employee.");
        }
    }

    /**
     * Get an Order by its ID.
     *
     * @param id of the order.
     * @return
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException
     */
    public static Order getOrder(int id) throws LoginException, ShopException
    {
        return OrderMapper.getOrder(id);
    }

    /**
     * Send an order to the customer by its ID. Used by an employee.
     *
     * @param id of the order.
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException
     */
    public static void sendOrder(int id) throws LoginException, ShopException
    {
        OrderMapper.sendOrder(id);
    }

    /**
     * Get a Bill of Materials from an Order.
     *
     * @param order
     * @return
     */
    public static BOM getBOM(Order order)
    {
        return new BOMLogic().getBOM(order);
    }
}

package malte.Logic;

import java.util.List;
import malte.Data.Exceptions.LoginException;
import malte.Data.Exceptions.ShopException;
import malte.Data.ModelFacade;
import malte.Data.ModelFacadeImpl;
import malte.Data.entities.BOM;
import malte.Data.entities.Order;
import malte.Data.entities.User;

/**
 * Facade Class.
 *
 * @author Malte
 */
public class ControllerFacadeImpl implements ControllerFacade
{

    public ControllerFacadeImpl()
    {
    }

    /**
     * User Login Facade.
     *
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public User login(String email, String password) throws LoginException, ShopException
    {
        ModelFacade model = new ModelFacadeImpl();
        return model.login(email, password);
    }

    /**
     * Create User Facade.
     *
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    @Override
    public User createUser(String email, String password) throws LoginException
    {
        User user = new User(email, password, "customer");
        ModelFacade model = new ModelFacadeImpl();
        model.createUser(user);
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
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public Order createOrder(int id, int length, int width, int height) throws LoginException, ShopException
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
     * @param user you want all orders from.
     * @return List of all orders from the User.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public List<Order> getOrders(User user) throws LoginException, ShopException
    {
        ModelFacade db = new ModelFacadeImpl();
        return db.getOrders(user);
    }

    /**
     * Get all the users. Used by an employee.
     *
     * @param user The User who is logged in. Requires an Employee User for it
     * to work.
     * @return List of all Users.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public List<User> getUsers(User user) throws LoginException, ShopException
    {
        ModelFacade db = new ModelFacadeImpl();
        return db.getUsers();
    }

    /**
     * Get an Order by its ID.
     *
     * @param id of the order.
     * @return an Order object.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public Order getOrder(int id) throws LoginException, ShopException
    {
        ModelFacade db = new ModelFacadeImpl();
        return db.getOrder(id);
    }

    /**
     * Send an order to the customer by its ID. Used by an employee.
     *
     * @param id of the order.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    @Override
    public void sendOrder(int id) throws LoginException, ShopException
    {
        ModelFacade db = new ModelFacadeImpl();
        db.sendOrder(id);
    }

    /**
     * Get a Bill of Materials from an Order.
     *
     * @param order you want to make a BOM from.
     * @return the BOM made from your order.
     */
    @Override
    public BOM getBOM(Order order)
    {
        return new BOMLogic().getBOM(order);
    }
}
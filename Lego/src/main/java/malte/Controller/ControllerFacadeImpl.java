package malte.Controller;

import java.util.List;
import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;
import malte.Model.ModelFacade;
import malte.Model.ModelFacadeImpl;
import malte.Model.entities.BOM;
import malte.Model.entities.Order;
import malte.Model.entities.User;

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
     * @throws LoginException
     * @throws malte.Model.Exceptions.ShopException Custom Exception. Caught in
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
     * @throws LoginException
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
     * @throws malte.Model.Exceptions.ShopException Custom Exception. Caught in
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
     * @param user
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Model.Exceptions.ShopException Custom Exception. Caught in
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
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Model.Exceptions.ShopException Custom Exception. Caught in
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
     * @return
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws malte.Model.Exceptions.ShopException Custom Exception. Caught in
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
     * @throws malte.Model.Exceptions.ShopException Custom Exception. Caught in
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
     * @param order
     * @return
     */
    @Override
    public BOM getBOM(Order order)
    {
        return new BOMLogic().getBOM(order);
    }
}

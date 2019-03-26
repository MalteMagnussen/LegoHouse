package malte.Presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.Data.Exceptions.LoginException;
import malte.Data.Exceptions.ShopException;
import malte.Data.entities.User;
import malte.Logic.ControllerFacade;
import malte.Logic.ControllerFacadeImpl;

/**
 * Login Class. Contains Login methods. Login, Register, Logout.
 *
 * @author Malte
 */
class Login extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, ShopException
    {

        String origin = request.getParameter("origin");

        switch (origin)
        {
            // Login an existing User
            case "login":
            {
                return Login(request);
            }
            // Register a new User
            case "registration":
            {
                return Registration(request);
            }
            // Log Out
            case "logout":
            {
                return Logout(request);
            }

        }
        return null;

    }

    /**
     * Login Method. Called from Facade. Uses DataMapper.
     *
     * @param request
     * @return View String.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    private String Login(HttpServletRequest request) throws LoginException, ShopException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ControllerFacade c = ControllerFacadeImpl.getInstance();
        User user = c.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        if (user.getRole().equals("employee"))
        {
            session.setAttribute("users", c.getUsers(user));
            return user.getRole() + "page";
        } else
        {
            return user.getRole() + "page";
        }

    }

    /**
     * Registration method. Called from Facade. Uses DataMapper.
     *
     * @param request
     * @return View String.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    private String Registration(HttpServletRequest request) throws LoginException
    {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2))
        {
            ControllerFacade c = ControllerFacadeImpl.getInstance();
            User user = c.createUser(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } else
        {
            throw new LoginException("The two passwords did not match.");
        }
    }

    /**
     * Log Out method.
     *
     * @param request
     * @return error.
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    private String Logout(HttpServletRequest request) throws LoginException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        throw new LoginException("Logged out");
    }

}

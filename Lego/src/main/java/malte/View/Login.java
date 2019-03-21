package malte.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.Controller.LogicFacade;
import malte.Controller.CustomException;
import malte.Model.entities.User;

/**
 * Login Class. Contains Login methods. Login, Register, Logout.
 *
 * @author Malte
 */
public class Login extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CustomException
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
     * @throws CustomException
     */
    private String Login(HttpServletRequest request) throws CustomException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        if (user.getRole().equals("employee"))
        {
            session.setAttribute("users", LogicFacade.getUsers(user));
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
     * @throws CustomException
     */
    private String Registration(HttpServletRequest request) throws CustomException
    {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2))
        {
            User user = LogicFacade.createUser(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } else
        {
            throw new CustomException("the two passwords did not match");
        }
    }

    /**
     * Log Out method.
     *
     * @param request
     * @return
     * @throws CustomException
     */
    private String Logout(HttpServletRequest request) throws CustomException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        throw new CustomException("Logged out");
    }

}

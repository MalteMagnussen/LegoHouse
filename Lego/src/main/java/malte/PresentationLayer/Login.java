package malte.PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.FunctionLayer.LogicFacade;
import malte.FunctionLayer.CustomException;
import malte.entities.User;

/**
 *
 * @author Malte
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CustomException {

        String origin = (String) request.getParameter("origin");

        switch (origin) {
            // Login an existing User
            case "login": {
                return Login(request);
            }
            // Register a new User
            case "registration": {
                return Registration(request);
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
    private String Login(HttpServletRequest request) throws CustomException {
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        return user.getRole() + "page";
    }

    /**
     * Registration method. Called from Facade. Uses DataMapper.
     *
     * @param request
     * @return View String.
     * @throws CustomException
     */
    private String Registration(HttpServletRequest request) throws CustomException {
        String email = (String) request.getParameter("email");
        String password1 = (String) request.getParameter("password1");
        String password2 = (String) request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } else {
            throw new CustomException("the two passwords did not match");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.Model.Exceptions.LoginException;
import malte.Model.entities.User;

/**
 * Simply Redirects. Used by Shop Button in the Menu dropdown.
 *
 * @author Malte
 */
public class Redirect extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user.getRole() + "page";
    }

}

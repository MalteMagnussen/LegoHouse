/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.Controller.LoginException;
import malte.Model.entities.User;

/**
 * Simply Redirects.
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

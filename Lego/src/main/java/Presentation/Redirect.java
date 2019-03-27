/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Data.Exceptions.LoginException;
import Data.Entities.User;

/**
 * Simply Redirects. Used by Shop Button in the Menu dropdown.
 *
 * @author Malte
 */
class Redirect extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user.getRole() + "page";
    }

}

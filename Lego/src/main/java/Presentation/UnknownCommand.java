package Presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.Exceptions.LoginException;

/**
 * Unknown Command. Throws Exception.
 *
 * @author Malte
 */
class UnknownCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        String msg = "Unknown command. Contact IT";
        throw new LoginException(msg);
    }

}

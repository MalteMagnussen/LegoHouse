package malte.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import malte.Model.Exceptions.LoginException;

/**
 * Unknown Command. Throws Exception.
 *
 * @author Malte
 */
public class UnknownCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        String msg = "Unknown command. Contact IT";
        throw new LoginException(msg);
    }

}

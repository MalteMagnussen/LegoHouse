package malte.View;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;

abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("Login", new Login());
        commands.put("Product", new Product());
        commands.put("Redirect", new Redirect());
    }

    static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter("command");
        if (commands == null)
        {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginException, ShopException;

}

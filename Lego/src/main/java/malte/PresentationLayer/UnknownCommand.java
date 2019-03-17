package malte.PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import malte.FunctionLayer.CustomException;

/**
 * Unknown Command. Throws Exception.
 *
 * @author Malte
 */
public class UnknownCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CustomException {
        String msg = "Unknown command. Contact IT";
        throw new CustomException(msg);
    }

}

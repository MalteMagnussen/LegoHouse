package malte.PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import malte.FunctionLayer.LoginSampleException;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String msg = "Unknown command. Contact IT";
        throw new LoginSampleException( msg );
    }

}

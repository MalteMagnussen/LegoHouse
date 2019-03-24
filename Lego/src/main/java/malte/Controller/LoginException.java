package malte.Controller;

/**
 * Login Exception, Sends user back to index.
 *
 * @author Malte
 */
public class LoginException extends Exception
{

    private static final long serialVersionUID = 1L;

    public LoginException(String msg)
    {
        super(msg);
    }

}

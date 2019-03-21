package malte.Controller;

/**
 * Custom Exception.
 *
 * @author Malte
 */
public class CustomException extends Exception
{

    private static final long serialVersionUID = 1L;

    public CustomException(String msg)
    {
        super(msg);
    }

}

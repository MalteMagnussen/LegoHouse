package malte.Model.Exceptions;

/**
 * Sends User back to their page, and not index.
 * 
 * @author Malte
 */
public class ShopException extends Exception
{

    private static final long serialVersionUID = 1L;

    public ShopException(String msg)
    {
        super(msg);
    }

}

package malte.FunctionLayer;

import malte.entities.User;
import malte.DBAccess.UserMapper;

/**
 * Facade Class.
 * @author Malte
 */
public class LogicFacade {

    /**
     * User Login Facade.
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws LoginSampleException 
     */
    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    /**
     * Create User Facade.
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws LoginSampleException 
     */
    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

}

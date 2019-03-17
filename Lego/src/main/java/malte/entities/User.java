package malte.entities;

import java.io.Serializable;

/**
 * User Entity Class.
 * @author Malte
 */
public class User implements Serializable {

    /**
     * Fields
     */
    private String password, email, role;
    private int id;

    /**
     * Constructor.
     *
     * @param email Users email
     * @param password Users password
     * @param role Users role
     */
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * JavaBean.
     */
    public User() {
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(String role) {
        this.role = role;
    }

}

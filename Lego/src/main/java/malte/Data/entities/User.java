package malte.Data.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User Entity Class.
 *
 * @author Malte
 */
public class User implements Serializable
{

    /**
     * Fields
     */
    private String password, email, role;
    private int id;
    private List<Order> orders = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param email Users email
     * @param password Users password
     * @param role Users role
     */
    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * JavaBean.
     */
    public User()
    {
    }

    /**
     * Get the Orders of this User
     *
     * @return List of Orders
     */
    public List<Order> getOrders()
    {
        return orders;
    }

    /**
     * Set the List of Orders
     *
     * @param orders List of Orders
     */
    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public String getRole()
    {
        return role;
    }

    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.role);
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id)
        {
            return false;
        }
        if (!Objects.equals(this.password, other.password))
        {
            return false;
        }
        if (!Objects.equals(this.email, other.email))
        {
            return false;
        }
        if (!Objects.equals(this.role, other.role))
        {
            return false;
        }
        return true;
    }

}

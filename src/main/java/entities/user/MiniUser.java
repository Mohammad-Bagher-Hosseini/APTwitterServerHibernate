package entities.user;

import java.io.Serializable;

public class MiniUser implements Serializable
{
    protected String userName;

    protected String name;

    protected String family;

    protected Bio bio;

    public MiniUser()
    {
        userName = null;
        name = null;
        family = null;
        bio = null;
    }

    public MiniUser(User user)
    {
        userName = user.getUserName();
        name = user.getName();
        family = user.getFamily();
        bio = user.getBio();
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFamily()
    {
        return family;
    }

    public void setFamily(String family)
    {
        this.family = family;
    }

    public Bio getBio()
    {
        return bio;
    }

    public void setBio(Bio bio)
    {
        this.bio = bio;
    }
}

package entities.user;


import java.io.Serializable;
import java.util.ArrayList;

public class ConnectedUsers implements Serializable
{
    ArrayList<MiniUser> miniUsers;

    public ConnectedUsers()
    {
        miniUsers = new ArrayList<>();
    }
}

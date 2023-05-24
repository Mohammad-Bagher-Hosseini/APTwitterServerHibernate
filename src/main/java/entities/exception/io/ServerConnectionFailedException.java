package entities.exception.io;

public class ServerConnectionFailedException extends ServerException
{
    public ServerConnectionFailedException()
    {
        super();
    }

    public ServerConnectionFailedException(String message)
    {
        super(message);
    }
}

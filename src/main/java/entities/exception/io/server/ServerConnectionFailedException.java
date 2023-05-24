package entities.exception.io.server;

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

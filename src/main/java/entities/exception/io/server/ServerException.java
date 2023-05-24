package entities.exception.io.server;

import java.io.IOException;

public class ServerException extends IOException
{
    public ServerException()
    {
        super();
    }

    public ServerException(String message)
    {
        super(message);
    }
}

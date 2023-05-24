package entities.exception.io;

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

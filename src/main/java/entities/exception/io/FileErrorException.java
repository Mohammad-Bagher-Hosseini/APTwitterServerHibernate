package entities.exception.io;

import java.io.IOException;

public class FileErrorException extends IOException
{
    public FileErrorException()
    {
        super();
    }

    public FileErrorException(String message)
    {
        super(message);
    }
}

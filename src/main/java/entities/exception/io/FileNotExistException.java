package entities.exception.io;

public class FileNotExistException extends FileErrorException
{
    public FileNotExistException()
    {
        super();
    }

    public FileNotExistException(String message)
    {
        super(message);
    }
}

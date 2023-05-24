package entities.exception.io;

public class FileNotImageException extends FileErrorException
{
    public FileNotImageException()
    {
        super();
    }

    public FileNotImageException(String message)
    {
        super(message);
    }
}

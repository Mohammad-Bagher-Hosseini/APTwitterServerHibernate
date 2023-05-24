package entities.exception.email;

public class EmailFormatException extends EmailException
{
    public EmailFormatException()
    {
        super();
    }

    public EmailFormatException(String message)
    {
        super(message);
    }
}

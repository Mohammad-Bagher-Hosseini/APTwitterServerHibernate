package entities.exception.password;

public class PasswordFormatException extends PasswordException
{
    public PasswordFormatException()
    {
        super();
    }

    public PasswordFormatException(String message)
    {
        super(message);
    }
}

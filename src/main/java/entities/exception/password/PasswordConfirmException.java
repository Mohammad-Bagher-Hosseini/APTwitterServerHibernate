package entities.exception.password;

public class PasswordConfirmException extends PasswordException
{
    public PasswordConfirmException()
    {
        super();
    }

    public PasswordConfirmException(String message)
    {
        super(message);
    }
}

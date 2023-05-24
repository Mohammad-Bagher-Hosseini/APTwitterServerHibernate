package entities.exception.password;

import entities.exception.TwitException;

public class PasswordException extends TwitException
{
    public PasswordException()
    {
        super();
    }

    public PasswordException(String message)
    {
        super(message);
    }
}

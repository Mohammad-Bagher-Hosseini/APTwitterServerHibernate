package entities.exception.email;

import entities.exception.TwitException;

public class EmailException extends TwitException
{
    public EmailException()
    {
        super();
    }

    public EmailException(String message)
    {
        super(message);
    }
}

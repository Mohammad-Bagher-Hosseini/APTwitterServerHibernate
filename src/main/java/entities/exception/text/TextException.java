package entities.exception.text;

import entities.exception.TwitException;

public class TextException extends TwitException
{
    public TextException()
    {
        super();
    }

    public TextException(String message)
    {
        super(message);
    }
}

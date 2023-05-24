package entities.exception;

public class SomethingWentWrongException extends TwitException
{
    public SomethingWentWrongException()
    {
        super();
    }

    public SomethingWentWrongException(String message)
    {
        super(message);
    }
}

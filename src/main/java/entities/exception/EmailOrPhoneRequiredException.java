package entities.exception;

public class EmailOrPhoneRequiredException extends TwitException
{
    public EmailOrPhoneRequiredException()
    {
        super();
    }

    public EmailOrPhoneRequiredException(String message)
    {
        super(message);
    }
}

package entities.exception.text;

public class TextTooLongException extends TextException
{
    public TextTooLongException()
    {
        super();
    }

    public TextTooLongException(String message)
    {
        super(message);
    }
}

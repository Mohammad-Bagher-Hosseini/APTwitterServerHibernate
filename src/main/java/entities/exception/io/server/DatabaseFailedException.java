package entities.exception.io.server;

public class DatabaseFailedException extends DatabaseException
{
    public DatabaseFailedException()
    {
        super();
    }

    public DatabaseFailedException(String message)
    {
        super(message);
    }
}

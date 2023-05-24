package entities.exception.io.server;

public class DataNotFoundException extends DatabaseException
{
    public DataNotFoundException(){super();}
    public DataNotFoundException(String message){super(message);}
}

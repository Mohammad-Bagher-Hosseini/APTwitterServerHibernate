package entities.server;

import entities.exception.io.server.DatabaseFailedException;
import entities.exception.io.server.ServerInvalidObjectException;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Respond implements Serializable
{
    private final RespondCode respondCode;
    private final String message;
    private final Object object;

    public Respond(RespondCode respondCode)
    {
        this.respondCode = respondCode;
        message = "";
        object = null;
    }

    public Respond(RespondCode respondCode, String message)
    {
        this.respondCode = respondCode;
        this.message = message;
        object = null;
    }

    public Respond(RespondCode respondCode, Object object)
    {
        this.respondCode = respondCode;
        message = "";
        this.object = object;
    }

    public Respond(RespondCode respondCode, String message, Object object)
    {
        this.respondCode = respondCode;
        this.message = message;
        this.object = object;
    }

    public RespondCode getRespondCode()
    {
        return respondCode;
    }

    public String getMessage()
    {
        return message;
    }

    public Object getObject()
    {
        return object;
    }

    public void send(ObjectOutputStream objectOutputStream) throws ServerInvalidObjectException
    {
        try
        {
            objectOutputStream.writeObject(this);
        } catch (IOException e)
        {
            e.printStackTrace();
            throw new ServerInvalidObjectException("Invalid object sent to client!");
        }
    }

    public void check() throws DatabaseFailedException
    {
        if(respondCode == RespondCode.FAIL)
            throw new DatabaseFailedException();
    }
}

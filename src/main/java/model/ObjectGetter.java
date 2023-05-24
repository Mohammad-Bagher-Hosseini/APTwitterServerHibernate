package model;

import entities.exception.io.ServerInvalidObjectException;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectGetter
{
    public static <T> T getObject(ObjectInputStream objectInputStream, Class<T> type) throws ServerInvalidObjectException
    {
        T t = null;
        try
        {
            t = (T) objectInputStream.readObject();
        } catch (IOException e)
        {
            throw new ServerInvalidObjectException("Invalid object received from client!");
        } catch (ClassNotFoundException e)
        {
            throw new ServerInvalidObjectException("The object received is not user!");
        }

        return t;
    }

//    public static <T> T getLargeObject(ObjectInputStream objectInputStream, Class<T> type) throws ServerInvalidObjectException
//    {
//        // gets objects like ImageBuilder
//    }
}

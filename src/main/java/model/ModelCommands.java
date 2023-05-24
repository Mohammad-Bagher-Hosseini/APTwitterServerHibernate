package model;

import entities.exception.io.ServerInvalidObjectException;
import entities.exception.io.server.DataNotFoundException;
import entities.exception.password.InvalidPasswordException;
import entities.exception.text.TextTooLongException;
import entities.image.Avatar;
import entities.image.Header;
import entities.server.Respond;
import entities.server.RespondCode;
import entities.user.Bio;
import entities.user.Password;
import entities.user.User;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import java.io.ObjectInputStream;
import java.util.List;

public class ModelCommands
{
    DatabaseManager databaseManager = new DatabaseManager();
    public Respond signUp(ObjectInputStream objectInputStream) throws ServerInvalidObjectException
    {
        User user = ObjectGetter.getObject(objectInputStream, User.class);

        // TODO: save to database, throw exception if failed
        try(Session session = databaseManager.sessionFactory.openSession())
        {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            // TODO: print suitable error
        }

        // TODO: add the newly created exceptions to both the client and the server project!!!

        // show the user as a test
        System.out.println(user);

        return new Respond(RespondCode.SUCCESS);
    }

    public Respond signIn(ObjectInputStream objectInputStream) throws ServerInvalidObjectException, DataNotFoundException, InvalidPasswordException
    {
        String userName = ObjectGetter.getObject(objectInputStream, String.class);
        Password passwordHash = ObjectGetter.getObject(objectInputStream, Password.class);

        // TODO: get user from database, throw exception if not found or some other error
        Session session = databaseManager.sessionFactory.openSession();
        List<User> users = session.createQuery("select u from User u", User.class).list();
        User user = databaseManager.find(users, userName);
        if(user.getPassHash().equals(passwordHash))
        {
            return new Respond(RespondCode.SUCCESS,user);
        }
        else
        {
            throw new InvalidPasswordException();
        }
        // TODO: add the newly created exceptions to both the client and the server project!!!

        // temporary user (because we don't have a database yet)
//        User user = new User();
//        user.setUserName(userName);
//        user.setPassword(passwordHash);

//        return new Respond(RespondCode.SUCCESS, user);
    }

    public Respond setAvatar(ObjectInputStream objectInputStream) throws ServerInvalidObjectException, DataNotFoundException
    {
        String userName = ObjectGetter.getObject(objectInputStream, String.class);
        Avatar avatar = ObjectGetter.getObject(objectInputStream, Avatar.class);

        // TODO: save to database, throw exception if failed
        Session session = databaseManager.sessionFactory.openSession();
        List<User> users = session.createQuery("select u from User u", User.class).list();
        User user = databaseManager.find(users, userName);
        user.setAvatar(avatar);
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        // TODO: add the newly created exceptions to both the client and the server project!!!

        // temporary showing the username (because we don't have a database yet)
        System.out.println(userName);

        return new Respond(RespondCode.SUCCESS);
    }

    public Respond setHeader(ObjectInputStream objectInputStream) throws ServerInvalidObjectException, DataNotFoundException
    {
        String userName = ObjectGetter.getObject(objectInputStream, String.class);
        Header header = ObjectGetter.getObject(objectInputStream, Header.class);

        // TODO: save to database, throw exception if failed
        Session session = databaseManager.sessionFactory.openSession();
        List<User> users = session.createQuery("select u from User u", User.class).list();
        User user = databaseManager.find(users, userName);
        user.setHeader(header);
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        // TODO: add the newly created exceptions to both the client and the server project!!!

        // temporary showing the username (because we don't have a database yet)
        System.out.println(userName);

        return new Respond(RespondCode.SUCCESS);
    }

    public Respond changeUserInformation(ObjectInputStream objectInputStream) throws ServerInvalidObjectException, DataNotFoundException, TextTooLongException
    {
        String userName = ObjectGetter.getObject(objectInputStream, String.class);
        Bio bio = ObjectGetter.getObject(objectInputStream, Bio.class);
        String location = ObjectGetter.getObject(objectInputStream, String.class);
        String website = ObjectGetter.getObject(objectInputStream, String.class);

        // TODO: change user information in database, throw exception if not found or some other error
        Session session = databaseManager.sessionFactory.openSession();
        List<User> users = session.createQuery("select u from User u", User.class).list();
        User user = databaseManager.find(users, userName);
        user.setBio(bio);
        user.setLocation(location);
        user.setWebsite(website);
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        // TODO: add the newly created exceptions to both the client and the server project!!!

        // temporary showing the user information (because we don't have a database yet)
        System.out.println(userName);
        System.out.println(bio);
        System.out.println(location);

        return new Respond(RespondCode.SUCCESS);
    }
}

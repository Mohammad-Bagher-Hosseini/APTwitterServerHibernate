package model;

import entities.exception.io.server.DataNotFoundException;
import entities.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DatabaseManager
{
    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    public User find(List<User> users, String userName) throws DataNotFoundException
    {
        for (User user: users)
        {
            if(user.getUserName().equals(userName))
            {
                return user;
            }
        }
        throw new DataNotFoundException();
    }
}

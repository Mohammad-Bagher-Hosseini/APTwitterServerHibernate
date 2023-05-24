package model;

import entities.exception.io.ServerInvalidObjectException;
import entities.server.Respond;
import entities.server.RespondCode;

import java.io.ObjectInputStream;

public class ModelCommandHandler
{
    private String command;
    private final ModelCommands modelCommands;

    public ModelCommandHandler()
    {
        modelCommands = new ModelCommands();
    }

    public void setCommand(String command)
    {
        this.command = command;
    }

    public Respond runCommand(ObjectInputStream objectInputStream)
    {
        try
        {
            return switch (command)
            {
                case "sign-up" -> modelCommands.signUp(objectInputStream);
                case "sign-in" -> modelCommands.signIn(objectInputStream);
                case "set-avatar" -> modelCommands.setAvatar(objectInputStream);
                case "set-header" -> modelCommands.setHeader(objectInputStream);
                case "change-user-information" -> modelCommands.changeUserInformation(objectInputStream);
                default -> new Respond(RespondCode.INVALID_COMMAND);
            };
        }
        catch (ServerInvalidObjectException e)
        {
            return new Respond(RespondCode.INVALID_OBJECT, e.getMessage());
        }
    }
}

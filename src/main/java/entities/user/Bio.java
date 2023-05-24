package entities.user;

import entities.exception.text.TextTooLongException;

import java.io.Serializable;

public class Bio implements Serializable
{
    private String text;

    public Bio()
    {
        text = "";
    }

    public Bio(String text) throws TextTooLongException
    {
        setText(text);
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text) throws TextTooLongException
    {
        if(text.length() > 160)
            throw new TextTooLongException("The bio must be at most 160 char long!");
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}

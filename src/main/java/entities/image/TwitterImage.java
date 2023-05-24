package entities.image;

import entities.exception.io.FileNotExistException;
import entities.exception.io.FileNotImageException;
import entities.exception.io.FileSizeException;
import entities.exception.io.ImageSizeException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public abstract class TwitterImage implements Serializable
{
    public BufferedImage avatar;

    public TwitterImage()
    {
        this.avatar = null;
    }

    public TwitterImage(BufferedImage avatar)
    {
        this.avatar = avatar;
    }

    // return 0 if you want to use WIDTH and HEIGHT instead of MAX_WIDTH and MAX_HEIGHT
    public abstract int getWidth();

    public abstract int getHeight();


    public abstract int getMaxWidth();

    public abstract int getMaxHeight();

    public abstract int getMaxByteSize();

    public TwitterImage(String path) throws FileSizeException, FileNotExistException, FileNotImageException, ImageSizeException
    {
        File file = new File(path);
        if (!file.exists())
            throw new FileNotExistException("File does not exist");

        if (file.length() > getMaxByteSize())
            throw new FileSizeException("File size is too large (max size : 1MB)");

        try
        {
            avatar = ImageIO.read(file);
        } catch (IOException e)
        {
            throw new FileNotImageException("File is not an image");
        }

        if (avatar == null)
            throw new FileNotImageException("File is not an image");

        if (getMaxWidth() == 0 && getMaxHeight() == 0)
        {
            if (avatar.getWidth() != getWidth() || avatar.getHeight() != getHeight())
                throw new ImageSizeException("Image size is not " + getWidth() + "X" + getHeight());
        } else
        {
            if (avatar.getWidth() > getMaxWidth() || avatar.getHeight() > getMaxHeight())
                throw new ImageSizeException("Image size should be less than or equal " + getMaxWidth() + "X" + getMaxHeight());
        }
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException
    {
        out.defaultWriteObject();
        ImageIO.write(avatar, "jpg", out);
    }
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        avatar = ImageIO.read(in);
    }
}

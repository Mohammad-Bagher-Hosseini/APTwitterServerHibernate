package entities.user;

import entities.exception.password.PasswordHashException;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Embeddable
public class Password implements Serializable
{
    private byte[] passwordHash = null;

    public Password(){}

    public Password(String password) throws PasswordHashException
    {
        hashPassword(password);
    }

    private void hashPassword(String password) throws PasswordHashException
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.passwordHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new PasswordHashException("The hashing went wrong");
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + Arrays.hashCode(passwordHash);
        return hash;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Arrays.equals(passwordHash, password.passwordHash);
    }

    @Override
    public String toString()
    {
        StringBuilder hexString = new StringBuilder(2 * passwordHash.length);
        for (byte hash : passwordHash)
        {
            String hex = Integer.toHexString(0xff & hash);
            if (hex.length() == 1)
            {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Server is running...");

        try(ClientConnectionReceiver clientConnectionReceiver = new ClientConnectionReceiver())
        {
            clientConnectionReceiver.start();
        }
        catch (IOException e)
        {
            System.out.println("Error in creating server socket!");
        }
    }
}
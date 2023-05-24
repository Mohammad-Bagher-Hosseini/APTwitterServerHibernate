import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientConnectionReceiver implements Closeable
{
    private static final int PORT = 5678;
    private final ExecutorService pool;
    private final ServerSocket serverSocket;

    public ClientConnectionReceiver() throws IOException
    {
        pool = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(PORT);
    }

    public void start()
    {
        while (true)
        {
            try
            {
                pool.execute(new ClientHandler(serverSocket.accept()));
                System.out.println("Client connected!" + LocalDate.now());
            } catch (IOException e)
            {
                System.out.println("Error in creating server socket!" + LocalDate.now());
            }
        }
    }

    @Override
    public void close() throws IOException
    {
        serverSocket.close();
        pool.shutdown();
    }
}

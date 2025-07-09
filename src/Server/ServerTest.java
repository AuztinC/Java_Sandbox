package Server;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;

public class ServerTest {
    Server server;

    @Before
    public void setup() {
        server = new Server(8080);
        new Thread(server::start).start(); // start async

    }

    @Test
    public void serverStartsOnPort() {
        assertTrue(server.isListening());
    }

    @Test
    public void serverAcceptsConnection() throws IOException {

        Socket client = new Socket("localhost", 8080);
        assertTrue(client.isConnected());

        server.stop();
    }

    @Test
    public void throwsExceptionWhenNoArgsProvided() {
        String[] args = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ServerArgs.parsePort(args);
        });

        assertEquals("Usage: java HttpServer <port number>", exception.getMessage());
    }



}

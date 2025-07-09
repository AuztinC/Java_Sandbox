package Server;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServerArgsTest {

    @Test
    public void throwsExceptionWhenNoArgsProvided() {
        String[] args = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ServerArgs.parsePort(args);
        });

        assertEquals("Usage: java HttpServer <port number>", exception.getMessage());
    }

    @Test
    public void returnsPortWhenOneArgProvided() {
        String[] args = {"8080"};
        int port = ServerArgs.parsePort(args);
        assertEquals(8080, port);
    }
}

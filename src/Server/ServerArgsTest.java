package Server;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ServerArgsTest {

    @Test
    public void parsesDefaultRootDirectory() {
        ServerArgs args = new ServerArgs(new String[]{});
        assertEquals(System.getProperty("user.dir"), args.getRoot());
    }

    @Test
    public void parsesRootDirectory() {
        ServerArgs args = new ServerArgs(new String[]{"-r", "/foo/bar"});
        assertEquals("/foo/bar", args.getRoot());
    }

    @Test
    public void parsesDefaultValues() {
        ServerArgs args = new ServerArgs(new String[]{});
        assertEquals(80, args.getPort());
    }

    @Test
    public void parsesCustomPort() {
        ServerArgs args = new ServerArgs(new String[]{"-p", "8080"});
        assertEquals(8080, args.getPort());
    }


}

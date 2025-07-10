package Server;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class HttpRequestTest {

    @Test
    public void throwsWhenGivenNoInput() {
        InputStream is = new ByteArrayInputStream("".getBytes());
        assertThrows(IllegalArgumentException.class, () -> {
            HttpRequest.parse(is);
        });
    }

    @Test
    public void throwsWhenGivenBadInput() {
        InputStream is = new ByteArrayInputStream("BLAH".getBytes());
        assertThrows(IllegalArgumentException.class, () -> {
            HttpRequest.parse(is);
        });
    }

    @Test
    public void acceptsCorrectMethodInput() throws IOException {
        InputStream is = new ByteArrayInputStream("GET".getBytes());
        HttpRequest req = HttpRequest.parse(is);
        assertEquals(Methods.GET, req.getMethod());
    }

    @Test
    public void throwsWithoutThreeInputParts() {
        InputStream is = new ByteArrayInputStream("GET HTTP/1.1\r\n\r\n".getBytes());
        assertThrows(IllegalArgumentException.class, () -> {
            HttpRequest.parse(is);
        });
    }

//    @Test
//    public void checksForGetMethod() {
//        InputStream is = new ByteArrayInputStream("GET / HTTP/1.1\r\n\r\n".getBytes());
//        HttpRequest req = HttpRequest.parse(is);
//        assertEquals(Methods.GET, req.getMethod());
//    }

}

package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequest {
    private final Methods method;

    public HttpRequest(Methods method) {
        this.method = method;
    }

    public Methods getMethod() {
        return method;
    }

    public static HttpRequest parse(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((is)));
        String requestLine = reader.readLine();

        if (requestLine == null || requestLine.isEmpty())
            throw new IllegalArgumentException("Empty request line");

        Methods method = Methods.fromString(requestLine);

        return new HttpRequest(method);
    }

}

package Server;

public enum Methods {
    GET;


    public static Methods fromString(String input) {
        try {
            return Methods.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported HTTP method: " + input);
        }
    }
}


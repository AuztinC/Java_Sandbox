package Server;

public enum Methods {
    GET,
    PUT;


    public static Methods confirmMethod(String input) {
        try {
            return Methods.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported HTTP method: " + input);
        }
    }
}


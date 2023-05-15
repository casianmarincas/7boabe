package pizzashop.exception;

public class RepositoryException extends RuntimeException {
    private final String message;

    public RepositoryException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

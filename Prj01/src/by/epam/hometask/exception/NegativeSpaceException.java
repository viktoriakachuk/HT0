package by.epam.hometask.exception;

public class NegativeSpaceException extends Exception {
    public NegativeSpaceException() {
        super();
    }

    public NegativeSpaceException(String message) {
        super(message);
    }

    public NegativeSpaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeSpaceException(Throwable cause) {
        super(cause);
    }
}

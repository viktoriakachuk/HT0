package by.epam.hometask.exception;

public class NegativeIlluminanceException extends Exception {
    public NegativeIlluminanceException(String message) {
        super(message);
    }

    public NegativeIlluminanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeIlluminanceException(Throwable cause) {
        super(cause);
    }

    public NegativeIlluminanceException() {
        super();
    }
}

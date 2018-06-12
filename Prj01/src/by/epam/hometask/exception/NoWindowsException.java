package by.epam.hometask.exception;

public class NoWindowsException extends Exception {
    public NoWindowsException() {
        super();
    }

    public NoWindowsException(String message) {
        super(message);
    }

    public NoWindowsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoWindowsException(Throwable cause) {
        super(cause);
    }
}

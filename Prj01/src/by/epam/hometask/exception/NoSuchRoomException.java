package by.epam.hometask.exception;

public class NoSuchRoomException extends Exception {
    public NoSuchRoomException() {
        super();
    }

    public NoSuchRoomException(String message) {
        super(message);
    }

    public NoSuchRoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchRoomException(Throwable cause) {
        super(cause);
    }
}

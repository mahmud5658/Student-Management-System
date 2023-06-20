package exceptions;

public class InvalidInputException extends Exception {
    public String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}

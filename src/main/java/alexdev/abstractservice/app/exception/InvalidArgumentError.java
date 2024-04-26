package alexdev.abstractservice.app.exception;

public class InvalidArgumentError extends RuntimeException{
    public InvalidArgumentError(String message) {
        super(message);
    }

    public static InvalidArgumentError withMessage(String message) {
        return new InvalidArgumentError(message);
    }
}

package alexdev.abstractservice.app.exception;

public class NameFoodAlreadyExistsError extends Exception{
    public NameFoodAlreadyExistsError(String message) {
        super(message);
    }


    public static NameFoodAlreadyExistsError forName(String name) {
        return new NameFoodAlreadyExistsError("food name: " + name + ", already exists");
    }

}

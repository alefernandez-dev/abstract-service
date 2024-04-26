package alexdev.abstractservice.app.exception;

import java.util.UUID;

public class FoodNotFoundError extends Exception{
    public FoodNotFoundError(String message) {
        super(message);
    }

    public static FoodNotFoundError forName(String name) {
        return new FoodNotFoundError("food with name: '" + name + "' not found");
    }

    public static FoodNotFoundError forId(UUID id) {
        return new FoodNotFoundError("food with id: '" + id + "' not found");
    }

}

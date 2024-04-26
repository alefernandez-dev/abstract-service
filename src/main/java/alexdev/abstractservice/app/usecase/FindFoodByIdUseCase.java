package alexdev.abstractservice.app.usecase;

import alexdev.abstractservice.app.exception.FoodNotFoundError;
import alexdev.abstractservice.app.output.FindFoodByIdOutput;
import alexdev.abstractservice.domain.Food;

import java.util.UUID;

public abstract class FindFoodByIdUseCase {

    protected final FindFoodByIdOutput findFoodByIdOutput;

    protected FindFoodByIdUseCase(FindFoodByIdOutput findFoodByIdOutput) {
        this.findFoodByIdOutput = findFoodByIdOutput;
    }

    public abstract Food find(UUID id) throws FoodNotFoundError;
}

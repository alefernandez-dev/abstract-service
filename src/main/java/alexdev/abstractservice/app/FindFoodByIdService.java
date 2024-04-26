package alexdev.abstractservice.app;

import alexdev.abstractservice.app.exception.FoodNotFoundError;
import alexdev.abstractservice.app.output.FindFoodByIdOutput;
import alexdev.abstractservice.app.usecase.FindFoodByIdUseCase;
import alexdev.abstractservice.domain.Food;

import java.util.UUID;

public class FindFoodByIdService extends FindFoodByIdUseCase {
    public FindFoodByIdService(FindFoodByIdOutput findFoodByIdOutput) {
        super(findFoodByIdOutput);
    }

    @Override
    public Food find(UUID id) throws FoodNotFoundError {
        return findFoodByIdOutput
                .find(id)
                .orElseThrow(() -> FoodNotFoundError.forId(id));
    }
}

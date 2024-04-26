package alexdev.abstractservice.app.usecase;

import alexdev.abstractservice.app.exception.NameFoodAlreadyExistsError;
import alexdev.abstractservice.app.output.RegisterFoodOutput;
import alexdev.abstractservice.domain.Food;

public abstract class RegisterFoodUseCase {

    protected final RegisterFoodOutput registerFoodOutput;

    protected RegisterFoodUseCase(RegisterFoodOutput registerFoodOutput) {
        this.registerFoodOutput = registerFoodOutput;
    }

    public abstract void register(String name, Food.Difficulty difficulty) throws NameFoodAlreadyExistsError;
}

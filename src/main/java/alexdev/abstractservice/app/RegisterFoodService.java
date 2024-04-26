package alexdev.abstractservice.app;

import alexdev.abstractservice.app.exception.NameFoodAlreadyExistsError;
import alexdev.abstractservice.app.output.RegisterFoodOutput;
import alexdev.abstractservice.app.usecase.RegisterFoodUseCase;
import alexdev.abstractservice.domain.Food;

import java.util.UUID;

public class RegisterFoodService extends RegisterFoodUseCase {
    public RegisterFoodService(RegisterFoodOutput registerFoodOutput) {
        super(registerFoodOutput);
    }

    @Override
    public void register(String name, Food.Difficulty difficulty) throws NameFoodAlreadyExistsError {

        if(registerFoodOutput.existsByName(name)) {
            throw NameFoodAlreadyExistsError.forName(name);
        }

        registerFoodOutput.register(new Food(
                UUID.randomUUID(),
                name,
                difficulty
        ));

    }
}

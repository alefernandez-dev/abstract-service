package alexdev.abstractservice.app.output;

import alexdev.abstractservice.domain.Food;

import java.util.UUID;

public interface RegisterFoodOutput {

    boolean existsByName(String name);
    void register(Food food);
}

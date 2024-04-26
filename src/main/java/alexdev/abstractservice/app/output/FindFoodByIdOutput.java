package alexdev.abstractservice.app.output;

import alexdev.abstractservice.domain.Food;

import java.util.Optional;
import java.util.UUID;

public interface FindFoodByIdOutput {
    Optional<Food> find(UUID id);
}

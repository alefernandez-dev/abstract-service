package alexdev.abstractservice.infrastructure.adapter;

import alexdev.abstractservice.app.output.FindFoodByIdOutput;
import alexdev.abstractservice.domain.Food;
import alexdev.abstractservice.infrastructure.db.jpa.FoodJpaRepository;

import java.util.Optional;
import java.util.UUID;

public class FindFoodByIdAdapter implements FindFoodByIdOutput {

    private final FoodJpaRepository foodJpaRepository;

    public FindFoodByIdAdapter(FoodJpaRepository foodJpaRepository) {
        this.foodJpaRepository = foodJpaRepository;
    }

    @Override
    public Optional<Food> find(UUID id) {
        return foodJpaRepository.findById(id).map(f -> new Food(f.getId(), f.getName(), Food.Difficulty.valueOf(f.getDifficulty())));
    }
}

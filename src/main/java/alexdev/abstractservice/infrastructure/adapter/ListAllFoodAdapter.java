package alexdev.abstractservice.infrastructure.adapter;

import alexdev.abstractservice.app.output.ListAllFoodOutputPort;
import alexdev.abstractservice.domain.Food;
import alexdev.abstractservice.infrastructure.db.jpa.FoodJpaRepository;

import java.util.List;

public class ListAllFoodAdapter implements ListAllFoodOutputPort {

    private final FoodJpaRepository foodJpaRepository;

    public ListAllFoodAdapter(FoodJpaRepository foodJpaRepository) {
        this.foodJpaRepository = foodJpaRepository;
    }

    @Override
    public List<Food> list() {
        return foodJpaRepository
                .findAll()
                .stream()
                .map(f -> new Food(f.getId(), f.getName(), Food.Difficulty.valueOf(f.getDifficulty())))
                .toList();
    }
}

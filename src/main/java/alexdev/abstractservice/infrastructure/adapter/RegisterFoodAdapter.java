package alexdev.abstractservice.infrastructure.adapter;

import alexdev.abstractservice.app.output.RegisterFoodOutput;
import alexdev.abstractservice.domain.Food;
import alexdev.abstractservice.infrastructure.db.jpa.FoodJpa;
import alexdev.abstractservice.infrastructure.db.jpa.FoodJpaRepository;

public class RegisterFoodAdapter implements RegisterFoodOutput {

    private final FoodJpaRepository foodJpaRepository;

    public RegisterFoodAdapter(FoodJpaRepository foodJpaRepository) {
        this.foodJpaRepository = foodJpaRepository;
    }

    @Override
    public boolean existsByName(String name) {
        return foodJpaRepository.existsByName(name);
    }

    @Override
    public void register(Food food) {
        foodJpaRepository.save(new FoodJpa(
                food.id(),
                food.name(),
                food.difficulty().name()
        ));
    }
}

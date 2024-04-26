package alexdev.abstractservice.infrastructure;

import alexdev.abstractservice.app.FindFoodByIdService;
import alexdev.abstractservice.app.ListAllFoodService;
import alexdev.abstractservice.app.RegisterFoodService;
import alexdev.abstractservice.app.output.FindFoodByIdOutput;
import alexdev.abstractservice.app.output.ListAllFoodOutputPort;
import alexdev.abstractservice.app.output.RegisterFoodOutput;
import alexdev.abstractservice.app.usecase.FindFoodByIdUseCase;
import alexdev.abstractservice.app.usecase.ListAllFoodUseCase;
import alexdev.abstractservice.app.usecase.RegisterFoodUseCase;
import alexdev.abstractservice.infrastructure.adapter.FindFoodByIdAdapter;
import alexdev.abstractservice.infrastructure.adapter.ListAllFoodAdapter;
import alexdev.abstractservice.infrastructure.adapter.RegisterFoodAdapter;
import alexdev.abstractservice.infrastructure.db.jpa.FoodJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public FindFoodByIdOutput findFoodByIdOutput(FoodJpaRepository foodJpaRepository) {
        return new FindFoodByIdAdapter(foodJpaRepository);
    }


    @Bean
    public ListAllFoodOutputPort listAllFoodOutputPort(FoodJpaRepository foodJpaRepository) {
        return new ListAllFoodAdapter(foodJpaRepository);
    }


    @Bean
    public RegisterFoodOutput registerFoodOutput(FoodJpaRepository foodJpaRepository) {
        return new RegisterFoodAdapter(foodJpaRepository);
    }


    @Bean
    public FindFoodByIdUseCase findFoodByNameUseCase(FindFoodByIdOutput findFoodByIdOutput) {
        return new FindFoodByIdService(findFoodByIdOutput);
    }


    @Bean
    public ListAllFoodUseCase listAllFoodUseCase(ListAllFoodOutputPort listAllFoodOutputPort) {
        return new ListAllFoodService(listAllFoodOutputPort);
    }


    @Bean
    public RegisterFoodUseCase registerFoodUseCase(RegisterFoodOutput registerFoodOutput) {
        return new RegisterFoodService(registerFoodOutput);
    }
}

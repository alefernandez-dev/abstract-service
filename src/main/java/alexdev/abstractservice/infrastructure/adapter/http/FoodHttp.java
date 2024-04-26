package alexdev.abstractservice.infrastructure.adapter.http;


import alexdev.abstractservice.app.exception.FoodNotFoundError;
import alexdev.abstractservice.app.exception.NameFoodAlreadyExistsError;
import alexdev.abstractservice.app.usecase.FindFoodByIdUseCase;
import alexdev.abstractservice.app.usecase.ListAllFoodUseCase;
import alexdev.abstractservice.app.usecase.RegisterFoodUseCase;
import alexdev.abstractservice.domain.Food;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/food")
public class FoodHttp {

    private final RegisterFoodUseCase registerFoodUseCase;
    private final FindFoodByIdUseCase findFoodByIdOutput;
    private final ListAllFoodUseCase listAllFoodUseCase;

    public FoodHttp(RegisterFoodUseCase registerFoodUseCase, FindFoodByIdUseCase findFoodByIdOutput, ListAllFoodUseCase listAllFoodUseCase) {
        this.registerFoodUseCase = registerFoodUseCase;
        this.findFoodByIdOutput = findFoodByIdOutput;
        this.listAllFoodUseCase = listAllFoodUseCase;
    }


    @PostMapping
    public ResponseEntity<MessageResponse> register(@RequestBody FoodRequest foodRequest) {
        try {
            registerFoodUseCase.register(foodRequest.name(), Food.difficultyFromString(foodRequest.difficulty()));
            return ResponseEntity.ok(new MessageResponse("food created successfully"));
        }catch (NameFoodAlreadyExistsError e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByName(@PathVariable UUID id) {
        try {
            var food = findFoodByIdOutput.find(id);
            return ResponseEntity.ok(new FoodResponse(food.id(), food.name(), food.difficulty().name()));
        }catch (FoodNotFoundError e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }

    }


    @GetMapping
    public ResponseEntity<List<FoodResponse>> list() {
       var foods = listAllFoodUseCase.listAll().stream().map(f -> new FoodResponse(f.id(), f.name(), f.difficulty().name())).toList();
       return ResponseEntity.ok(foods);
    }

}

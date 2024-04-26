package alexdev.abstractservice.app.usecase;

import alexdev.abstractservice.app.output.ListAllFoodOutputPort;
import alexdev.abstractservice.domain.Food;

import java.util.List;

public abstract class ListAllFoodUseCase {

    protected final ListAllFoodOutputPort listAllFoodOutputPort;

    protected ListAllFoodUseCase(ListAllFoodOutputPort listAllFoodOutputPort) {
        this.listAllFoodOutputPort = listAllFoodOutputPort;
    }

    public abstract List<Food> listAll();

}

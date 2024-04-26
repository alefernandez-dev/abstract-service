package alexdev.abstractservice.app;

import alexdev.abstractservice.app.output.ListAllFoodOutputPort;
import alexdev.abstractservice.app.usecase.ListAllFoodUseCase;
import alexdev.abstractservice.domain.Food;

import java.util.List;

public class ListAllFoodService extends ListAllFoodUseCase {
    public ListAllFoodService(ListAllFoodOutputPort listAllFoodOutputPort) {
        super(listAllFoodOutputPort);
    }

    @Override
    public List<Food> listAll() {
        return listAllFoodOutputPort.list();
    }
}

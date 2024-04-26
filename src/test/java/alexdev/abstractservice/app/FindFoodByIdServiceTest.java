package alexdev.abstractservice.app;

import alexdev.abstractservice.app.exception.FoodNotFoundError;
import alexdev.abstractservice.app.output.FindFoodByIdOutput;
import alexdev.abstractservice.domain.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindFoodByIdServiceTest {

    @Mock
    private FindFoodByIdOutput findFoodByIdOutputMock;

    @InjectMocks
    private FindFoodByIdService findFoodByIdService;


    private Food food;

    @BeforeEach
    void setUp() {

        food = new Food(UUID.randomUUID(),"FoodName", Food.Difficulty.HIGH);

    }


    @Test
    public void findFoodByIdSuccessfully() {

        when(findFoodByIdOutputMock.find(food.id())).thenReturn(Optional.of(food));

        var foundFood = assertDoesNotThrow(() -> findFoodByIdService.find(food.id()));

        assertEquals(food, foundFood);

    }

    @Test
    public void findFoodByIdThrowsException() {

        when(findFoodByIdOutputMock.find(food.id())).thenReturn(Optional.empty());

        assertThrowsExactly(
                FoodNotFoundError.class,
                () -> findFoodByIdService.find(food.id())
        );

    }
}
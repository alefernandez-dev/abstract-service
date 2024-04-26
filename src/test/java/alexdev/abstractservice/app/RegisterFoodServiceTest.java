package alexdev.abstractservice.app;

import alexdev.abstractservice.app.exception.NameFoodAlreadyExistsError;
import alexdev.abstractservice.app.output.RegisterFoodOutput;
import alexdev.abstractservice.domain.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterFoodServiceTest {

    @Mock
    private RegisterFoodOutput registerFoodOutputMock;

    @InjectMocks
    private RegisterFoodService registerFoodService;

    private Food food;


    @BeforeEach
    void setUp() {
        food = new Food(UUID.randomUUID(), "FoodName", Food.Difficulty.HIGH);
    }



    @Test
    public void createNewFoodSuccessAndVerifyOutputPortMethodsExecutionTimes() {

        when(registerFoodOutputMock.existsByName(food.name())).thenReturn(false);

        assertDoesNotThrow(() -> registerFoodService.register(food.name(), food.difficulty()));

        verify(registerFoodOutputMock, times(1)).existsByName(any(String.class));
        verify(registerFoodOutputMock, times(1)).register(any(Food.class));

    }


    @Test
    public void createNewFoodWithExistingNameThrowsException() {

        when(registerFoodOutputMock.existsByName(food.name())).thenReturn(true);

        assertThrowsExactly(
                NameFoodAlreadyExistsError.class,
                () -> registerFoodService.register(food.name(), food.difficulty())
        );


    }

}
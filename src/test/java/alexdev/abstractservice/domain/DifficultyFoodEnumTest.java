package alexdev.abstractservice.domain;

import alexdev.abstractservice.app.exception.InvalidArgumentError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyFoodEnumTest {


    @Test
    public void createDifficultyEnumFromStringSuccessfully() {

        Food.Difficulty d1 = assertDoesNotThrow(() -> Food.difficultyFromString("HIGH"));
        Food.Difficulty d2 = assertDoesNotThrow(() -> Food.difficultyFromString("MeDIuM"));
        Food.Difficulty d3 = assertDoesNotThrow(() -> Food.difficultyFromString("low"));

        assertEquals(Food.Difficulty.HIGH, d1);
        assertEquals(Food.Difficulty.MEDIUM, d2);
        assertEquals(Food.Difficulty.LOW, d3);


    }


    @Test
    public void createDifficultyEnumFromInvalidStringThrowsException() {

        assertThrows(InvalidArgumentError.class, () -> Food.difficultyFromString(null));
        assertThrows(InvalidArgumentError.class, () -> Food.difficultyFromString(""));
        assertThrows(InvalidArgumentError.class, () -> Food.difficultyFromString("INVALID_VALUE"));

    }


}
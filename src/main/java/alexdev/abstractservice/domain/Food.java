package alexdev.abstractservice.domain;

import alexdev.abstractservice.app.exception.InvalidArgumentError;

import java.util.UUID;

public record Food(UUID id, String name, Difficulty difficulty) {
    public enum Difficulty {
        HIGH,
        MEDIUM,
        LOW
    }

    public static Difficulty difficultyFromString(String difficulty) {
        try {
            return Difficulty.valueOf(difficulty.toUpperCase());
        } catch (Exception e) {
            throw InvalidArgumentError.withMessage("invalid enum value");
        }
    }
}

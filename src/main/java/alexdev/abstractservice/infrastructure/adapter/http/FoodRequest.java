package alexdev.abstractservice.infrastructure.adapter.http;

import alexdev.abstractservice.domain.Food;

import java.io.Serializable;

public record FoodRequest(String name, String difficulty) implements Serializable {
}

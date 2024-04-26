package alexdev.abstractservice.infrastructure.adapter.http;

import java.io.Serializable;
import java.util.UUID;

public record FoodResponse(UUID id, String name, String difficulty) implements Serializable {
}

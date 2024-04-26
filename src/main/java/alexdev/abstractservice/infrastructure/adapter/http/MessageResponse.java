package alexdev.abstractservice.infrastructure.adapter.http;

import java.io.Serializable;

public record MessageResponse(String message) implements Serializable {

    public static MessageResponse withErrorMessage(String message) {
        return new MessageResponse(message);
    }

}

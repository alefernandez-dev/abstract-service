package alexdev.abstractservice.infrastructure.adapter.http;

import alexdev.abstractservice.app.exception.InvalidArgumentError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {


    @ExceptionHandler({Exception.class})
    public ResponseEntity<MessageResponse> handleExceptions(Exception e) {

        if(e instanceof InvalidArgumentError) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageResponse.withErrorMessage("error: " + e.getMessage()));
        }

        return ResponseEntity.internalServerError().body(MessageResponse.withErrorMessage("error: " + e.getMessage()));
    }


}

package in.hp.java.userservice.exception;

import in.hp.java.userservice.dto.UserApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private UserApiResponse<Object> generateUserApiResponse(String message, String desciption) {
        return UserApiResponse.builder()
                .response(new ApiError(message, desciption))
                .build();
    }

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<UserApiResponse<Object>> handleUserNotFoundException(
            UserNotFoundException ex,
            WebRequest request
    ) {
        log.error("UserNotFoundException: {}", ex.getMessage());
        var userApiResponse = generateUserApiResponse(
                ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userApiResponse);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<UserApiResponse<Object>> handleException(Exception ex) {
        log.error("Exception Occurred: {}", ex.getMessage());
        var userApiResponse = generateUserApiResponse(
                ex.getMessage(), ex.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userApiResponse);
    }

}

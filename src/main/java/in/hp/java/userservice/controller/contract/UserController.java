package in.hp.java.userservice.controller.contract;

import in.hp.java.userservice.dto.UserApiResponse;
import in.hp.java.userservice.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UserController {

    @PostMapping
    ResponseEntity<Object> addUser(@RequestBody UserDto user);

    @GetMapping
    ResponseEntity<UserApiResponse<Object>> getUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserApiResponse<Object>> getUser(@PathVariable Long id);

    @PutMapping
    ResponseEntity<Object> updateUser(@RequestBody UserDto user);

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteUser(@PathVariable Long id);

    default <T> ResponseEntity<UserApiResponse<Object>> generateResponse(T response, HttpStatus httpStatus) {
        UserApiResponse<Object> userApiResponse = UserApiResponse.builder()
                .response(response)
                .build();

        return ResponseEntity.status(httpStatus)
                .body(userApiResponse);
    }
}

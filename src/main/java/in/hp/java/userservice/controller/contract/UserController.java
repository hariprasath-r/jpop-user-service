package in.hp.java.userservice.controller.contract;

import in.hp.java.userservice.dto.UserApiResponse;
import in.hp.java.userservice.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "User data manipulation")
@RequestMapping("/users")
public interface UserController {

    @Operation(summary = "Adds a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created"),
            @ApiResponse(responseCode = "400", description = "Invalid Input"),
            @ApiResponse(responseCode = "500", description = "Processing Error")
    })
    @PostMapping
    ResponseEntity<Object> addUser(@RequestBody UserDto user);

    @Operation(summary = "Gets all Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of users"),
            @ApiResponse(responseCode = "500", description = "Processing Error")
    })
    @GetMapping
    ResponseEntity<UserApiResponse<List<UserDto>>> getUsers();

    @Operation(summary = "Gets a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Found"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "500", description = "Processing Error")
    })
    @GetMapping("/{id}")
    ResponseEntity<UserApiResponse<UserDto>> getUser(@PathVariable Long id);

    @Operation(summary = "Updates a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Updated"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "500", description = "Processing Error")
    })
    @PutMapping
    ResponseEntity<Object> updateUser(@RequestBody UserDto user);

    @Operation(summary = "Deletes a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "410", description = "User Deleted"),
            @ApiResponse(responseCode = "500", description = "Processing Error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteUser(@PathVariable Long id);

    default <T> ResponseEntity<UserApiResponse<T>> generateResponse(T response, HttpStatus httpStatus) {
        UserApiResponse<T> userApiResponse = UserApiResponse.<T>builder()
                .response(response)
                .build();

        return ResponseEntity.status(httpStatus)
                .body(userApiResponse);
    }
}

package in.hp.java.userservice.controller;

import in.hp.java.userservice.controller.contract.UserController;
import in.hp.java.userservice.dto.UserApiResponse;
import in.hp.java.userservice.dto.UserDto;
import in.hp.java.userservice.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User Controller")
@RestController
@Slf4j
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Object> addUser(UserDto user) {
        log.info("Add User: {}", user);
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<UserApiResponse<List<UserDto>>> getUsers() {
        log.info("Get Users");
        return generateResponse(userService.getUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserApiResponse<UserDto>> getUser(Long id) {
        log.info("Get User: {}", id);
        return generateResponse(userService.getUser(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateUser(UserDto user) {
        log.info("Update User: {}", user);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Object> deleteUser(Long id) {
        log.info("Delete User: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

}

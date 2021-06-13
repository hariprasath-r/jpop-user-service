package in.hp.java.userservice.service;

import in.hp.java.userservice.dto.UserDto;
import in.hp.java.userservice.entity.User;
import in.hp.java.userservice.exception.UserNotFoundException;
import in.hp.java.userservice.mapper.UserMapper;
import in.hp.java.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDto userDto) {
        var user = UserMapper.mapToEntity(userDto);
        log.info("Mapped to entity: {}", user);
        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        List<User> userList = userRepository.findAll();
        log.info("Users from repo: {}", userList);
        return userList.stream().map(UserMapper::mapToDto).collect(Collectors.toList());
    }

    public UserDto getUser(Long id) {
        return UserMapper.mapToDto(findUser(id));
    }

    private User findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            log.info("User found: {}", id);
            return user.get();
        } else {
            var errorMessage = "User not found: " + id;
            log.info(errorMessage);
            throw new UserNotFoundException(errorMessage);
        }
    }

    public void updateUser(UserDto user) {
        findUser(user.getId());
        userRepository.save(UserMapper.mapToEntity(user));
        log.info("User {}, updated successfully.", user.getId());
    }

    public void deleteUser(Long id) {
        findUser(id);
        userRepository.deleteById(id);
        log.info("User {}, deleted successfully.", id);
    }

}

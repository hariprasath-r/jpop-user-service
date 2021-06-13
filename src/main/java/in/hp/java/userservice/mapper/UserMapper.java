package in.hp.java.userservice.mapper;

import in.hp.java.userservice.dto.UserDto;
import in.hp.java.userservice.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User mapToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }
}

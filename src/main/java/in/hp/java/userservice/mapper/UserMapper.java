package in.hp.java.userservice.mapper;

import in.hp.java.userservice.dto.UserDto;
import in.hp.java.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}

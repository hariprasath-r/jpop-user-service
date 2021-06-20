package in.hp.java.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Schema(name = "User", description = "User Schema")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotNull(message = "Name should not be null")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Should be a valid email address")
    private String email;

}

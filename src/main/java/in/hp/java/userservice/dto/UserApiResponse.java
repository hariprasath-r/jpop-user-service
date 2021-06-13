package in.hp.java.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserApiResponse<T> {

    T response;

    @Builder.Default
    LocalDateTime timestamp = LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("IST")));

}

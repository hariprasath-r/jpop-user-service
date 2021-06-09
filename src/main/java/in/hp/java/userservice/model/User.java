package in.hp.java.userservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private Long id;

    private String name;

    private String email;

}

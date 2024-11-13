package hello.mycalendarv2.model.entity;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="user")
@NoArgsConstructor
public class User extends DateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Event> events = new ArrayList<>();

    public User(CreateUserRequestDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }
}

package hello.mycalendarv2.model.dto;

import hello.mycalendarv2.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}

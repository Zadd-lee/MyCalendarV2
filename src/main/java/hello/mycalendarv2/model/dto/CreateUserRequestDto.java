package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequestDto {

    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private String password;

}

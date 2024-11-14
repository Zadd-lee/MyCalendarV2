package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;

}

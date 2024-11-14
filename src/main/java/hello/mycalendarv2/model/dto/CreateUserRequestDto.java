package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequestDto {

    @NotBlank(message = "이름은 비어둘 수 없습니다")
    @Size(min = 2,max = 5)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}

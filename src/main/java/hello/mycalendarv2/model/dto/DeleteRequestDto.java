package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteRequestDto {

    @NotBlank(message = "비밀번호는 공백은 허용하지 않습니다")
    private String password;
}

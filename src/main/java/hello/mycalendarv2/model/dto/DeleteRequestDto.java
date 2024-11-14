package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteRequestDto {

    @NotNull
    private String password;
}

package hello.mycalendarv2.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteUserRequestDto {

    @NotNull
    private String password;

    public DeleteUserRequestDto(@JsonProperty("password") String password) {
        this.password = password;
    }
}

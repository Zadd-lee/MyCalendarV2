package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateEventRequestDto {
    @NotBlank
    private String title;
    @NotNull
    private String contexts;
    @NotBlank
    @Size(max = 5)
    private String userName;

}

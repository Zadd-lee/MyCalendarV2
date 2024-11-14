package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateEventRequestDto {
    @NotNull
    private String title;
    private String contexts;
    @NotNull
    @Size(max = 8)
    private String userName;

}

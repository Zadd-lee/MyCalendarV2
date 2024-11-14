package hello.mycalendarv2.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCommentRequestDto {
    @Size(max=2000)
    private String comment;
    @NotNull
    private Long userId;
    @NotNull
    private Long event_id;
}

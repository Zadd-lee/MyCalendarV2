package hello.mycalendarv2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequestDto {
    private String title;
    private String contexts;
    private String userName;

}

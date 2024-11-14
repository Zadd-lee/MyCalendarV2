package hello.mycalendarv2.model.dto;

import hello.mycalendarv2.model.entity.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventResponseDto {

    private Long id;
    private String title;
    private String contexts;
    private String userName;

    public EventResponseDto(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.contexts = event.getContexts();
        this.userName = event.getUser().getName();
    }

}

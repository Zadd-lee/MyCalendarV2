package hello.mycalendarv2.model.entity;

import hello.mycalendarv2.model.dto.CreateEventRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    private String title;

    private String contexts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Event(CreateEventRequestDto dto,User user) {
        this.title = dto.getTitle();
        this.contexts = dto.getContexts();
        this.user = user;
    }
}

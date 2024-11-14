package hello.mycalendarv2.model.entity;

import hello.mycalendarv2.model.dto.CreateCommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Comment(CreateCommentRequestDto dto,User user, Event event) {
        this.comment = dto.getComment();
        this.user = user;
        this.event = event;
    }
}

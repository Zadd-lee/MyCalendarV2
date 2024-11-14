package hello.mycalendarv2.model.dto;

import hello.mycalendarv2.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String comment;
    private Long userId;
    private Long event_id;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.userId = comment.getUser().getId();
        this.event_id = comment.getEvent().getId();
    }
}

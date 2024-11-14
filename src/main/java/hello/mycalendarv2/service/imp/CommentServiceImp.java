package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.CommentResponseDto;
import hello.mycalendarv2.model.dto.CreateCommentRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;
import hello.mycalendarv2.model.entity.Comment;
import hello.mycalendarv2.model.entity.Event;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.CommentRepository;
import hello.mycalendarv2.repository.EventRepository;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.CommentService;
import hello.mycalendarv2.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImp implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    @Override
    public CommentResponseDto create(CreateCommentRequestDto dto) {
        User userById = userRepository.findByIdOrElseThrows(dto.getUserId());
        Event eventById = eventRepository.findByIdOrElseThrows(dto.getEvent_id());

        Comment comment = new Comment(dto,userById,eventById);
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(savedComment);
    }

    @Override
    public CommentResponseDto findById(Long id) {
        Comment commentById = commentRepository.findByIdOrElseThrows(id);
        return new CommentResponseDto(commentById);


    }

    @Override
    public void delete(Long id, DeleteRequestDto dto) {
        Comment comment = commentRepository.findByIdOrElseThrows(id);
        UserValidator validator = new UserValidator();
        validator.validatePassword(comment.getUser().getPassword(), dto.getPassword());
        commentRepository.delete(comment);

    }
}

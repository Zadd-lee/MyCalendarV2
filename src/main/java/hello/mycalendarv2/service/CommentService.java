package hello.mycalendarv2.service;

import hello.mycalendarv2.model.dto.CommentResponseDto;
import hello.mycalendarv2.model.dto.CreateCommentRequestDto;

public interface CommentService {
    CommentResponseDto create(CreateCommentRequestDto dto);

    CommentResponseDto findById(Long id);
}

package hello.mycalendarv2.service;

import hello.mycalendarv2.model.dto.CommentResponseDto;
import hello.mycalendarv2.model.dto.CreateCommentRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;

public interface CommentService {
    CommentResponseDto create(CreateCommentRequestDto dto);

    CommentResponseDto findById(Long id);

    void delete(Long id, DeleteRequestDto dto);
}

package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CommentResponseDto;
import hello.mycalendarv2.model.dto.CreateCommentRequestDto;
import hello.mycalendarv2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final ValidationAutoConfiguration validationAutoConfiguration;

    @PostMapping
    public ResponseEntity<CommentResponseDto> create(@Validated @RequestBody CreateCommentRequestDto dto) {
        CommentResponseDto commentResponseDto = commentService.create(dto);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }
}

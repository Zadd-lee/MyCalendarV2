package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CommentResponseDto;
import hello.mycalendarv2.model.dto.CreateCommentRequestDto;
import hello.mycalendarv2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> create(@Validated @RequestBody CreateCommentRequestDto dto) {
        CommentResponseDto commentResponseDto = commentService.create(dto);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id) {
        CommentResponseDto commentResponseDto = commentService.findById(id);

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

}

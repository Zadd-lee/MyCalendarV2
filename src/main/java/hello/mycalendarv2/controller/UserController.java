package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;
import hello.mycalendarv2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Validated @RequestBody CreateUserRequestDto dto) {

        UserResponseDto responseDto = userService.createUser(dto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }
}

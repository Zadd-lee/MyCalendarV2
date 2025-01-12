package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;
import hello.mycalendarv2.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody   CreateUserRequestDto dto) {
        UserResponseDto responseDto = userService.createUser(dto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(
            @PathVariable Long id
    ) {
        UserResponseDto responseDto = userService.findById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @Valid @RequestBody DeleteRequestDto dto
    ) {
        userService.delete(id,dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

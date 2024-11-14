package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.LoginRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;
import hello.mycalendarv2.service.LoginService;
import hello.mycalendarv2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @Validated @RequestBody LoginRequestDto dto,
            HttpServletRequest request) {
        loginService.login(dto);
        HttpSession session = request.getSession(true);
        session.setAttribute("email", dto.getEmail());


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> login(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserResponseDto> signIn(
            @Validated @RequestBody CreateUserRequestDto dto) {
        UserResponseDto responseDto = userService.createUser(dto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}

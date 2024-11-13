package hello.mycalendarv2.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserValidator {
    public void validatePassword(String password, String inputPassword) {

        if (!password.equals(inputPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");
        }
    }
}

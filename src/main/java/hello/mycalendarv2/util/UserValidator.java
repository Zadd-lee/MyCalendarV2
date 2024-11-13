package hello.mycalendarv2.util;

import hello.mycalendarv2.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserValidator {
    public void validatePassword(User user, String password) {

        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");
        }
    }
}

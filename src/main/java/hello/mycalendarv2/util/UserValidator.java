package hello.mycalendarv2.util;

import hello.mycalendarv2.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UserValidator {
    public void validatePassword(String password, String inputPassword) {

        if (!password.equals(inputPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");
        }
    }

    public User validatePasswordWithUsers(List<User> users,String inputPassword) {
        User user = users.stream()
                .filter(u -> u.getPassword().equals(inputPassword))
                .findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다"));
        return user;
    }
}

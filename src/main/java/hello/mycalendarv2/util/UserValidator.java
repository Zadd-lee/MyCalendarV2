package hello.mycalendarv2.util;

import hello.mycalendarv2.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RequiredArgsConstructor
public class UserValidator {
    private PasswordEncoder encoder = new PasswordEncoder();
    public boolean validatePassword(String password, String inputPassword) {

        return encoder.matches(inputPassword, password);
    }

    public User validatePasswordWithUsers(List<User> users,String inputPassword) {
        User user = users.stream()
                .filter(u -> encoder.matches(inputPassword,u.getPassword()))
                .findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다"));
        return user;
    }
}

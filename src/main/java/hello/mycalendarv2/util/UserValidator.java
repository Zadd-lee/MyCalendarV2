package hello.mycalendarv2.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final PasswordEncoder encoder;
    public boolean validatePassword(String password, String inputPassword) {

        return encoder.matches(inputPassword, password);
    }
}

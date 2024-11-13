package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.LoginRequestDto;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.LoginService;
import hello.mycalendarv2.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImp implements LoginService {
    private final UserRepository userRepository;
    UserValidator validator = new UserValidator();
    @Override
    public void login(LoginRequestDto dto) {
        List<User> users = userRepository.findByEmail(dto.getEmail());
        User validatedUser = validator.validatePasswordWithUsers(users, dto.getPassword());
        return;
    }
}

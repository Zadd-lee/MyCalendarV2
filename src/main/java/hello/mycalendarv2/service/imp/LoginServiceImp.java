package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.LoginRequestDto;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.LoginService;
import hello.mycalendarv2.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImp implements LoginService {
    private final UserRepository userRepository;
    private final UserValidator validator;
    @Override
    public void login(LoginRequestDto dto) {
        List<User> users = userRepository.findByEmail(dto.getEmail());
        validateUsers(dto, users);
    }

    private void validateUsers(LoginRequestDto dto, List<User> users) {
        for (User user : users) {
            if (validateUser(dto, user)) return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다");
    }

    private boolean validateUser(LoginRequestDto dto, User user) {
        if (validator.validatePassword(user.getPassword(), dto.getPassword())) {
            return true;
        }
        return false;
    }
}

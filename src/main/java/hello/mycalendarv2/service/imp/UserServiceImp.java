package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.UserService;
import hello.mycalendarv2.util.PasswordEncoder;
import hello.mycalendarv2.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserValidator validator;

    @Override
    public UserResponseDto createUser(CreateUserRequestDto dto) {
        PasswordEncoder encoder = new PasswordEncoder();
        User user = new User(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        User savedUsers = userRepository.save(user);
        return new UserResponseDto(savedUsers);
    }

    @Override
    public UserResponseDto findById(Long id) {
        User findUser = userRepository.findByIdOrElseThrows(id);
        return new UserResponseDto(findUser);
    }

    @Override
    public void delete(Long id, DeleteRequestDto dto) {
        User user = userRepository.findByIdOrElseThrows(id);
        validatorUser(dto, user);
        userRepository.deleteById(id);
    }

    private void validatorUser(DeleteRequestDto dto, User user) {
        if (validator.validatePassword(user.getPassword(), dto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "비밀번호 오류");

        }
    }
}

package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.DeleteUserRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.UserService;
import hello.mycalendarv2.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    UserValidator validator = new UserValidator();

    @Override
    public UserResponseDto createUser(CreateUserRequestDto dto) {
        User user = new User(dto);
        User savedUsers = userRepository.save(user);
        return new UserResponseDto(savedUsers);
    }

    @Override
    public UserResponseDto findById(Long id) {
        User findUser = userRepository.findByIdOrElseThrows(id);
        return new UserResponseDto(findUser);
    }

    @Override
    public void delete(Long id, DeleteUserRequestDto dto) {
        User user = userRepository.findByIdOrElseThrows(id);
        validator.validatePassword(user, dto.getPassword());
        userRepository.deleteById(id);
    }
}

package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(CreateUserRequestDto dto) {
        User user = new User(dto);
        User savedUsers = userRepository.save(user);
        return new UserResponseDto(savedUsers);
    }
}

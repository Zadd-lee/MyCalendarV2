package hello.mycalendarv2.service;

import hello.mycalendarv2.model.dto.CreateUserRequestDto;
import hello.mycalendarv2.model.dto.UserResponseDto;


public interface UserService {
    UserResponseDto createUser(CreateUserRequestDto dto);
}

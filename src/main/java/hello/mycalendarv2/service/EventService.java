package hello.mycalendarv2.service;

import hello.mycalendarv2.model.dto.CreateEventRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;
import hello.mycalendarv2.model.dto.EventResponseDto;

public interface EventService {
    EventResponseDto createEvent(CreateEventRequestDto dto);

    EventResponseDto findById(Long id);

    void delete(Long id, DeleteRequestDto dto);
}

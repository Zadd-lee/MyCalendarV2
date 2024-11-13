package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.CreateEventRequestDto;
import hello.mycalendarv2.model.dto.EventResponseDto;
import hello.mycalendarv2.model.entity.Event;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.EventRepository;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public EventResponseDto createEvent(CreateEventRequestDto dto) {
        User user = userRepository.findByNameOrElseThrows(dto.getUserName());

        Event event = new Event(dto,user);
        Event savedEvent = eventRepository.save(event);
        return new EventResponseDto(savedEvent);
    }

    @Transactional
    @Override
    public EventResponseDto findById(Long id) {
        Event findEventById = eventRepository.findByIdOrElseThrows(id);
        return new EventResponseDto(findEventById);
    }
}

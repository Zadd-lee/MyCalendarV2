package hello.mycalendarv2.service.imp;

import hello.mycalendarv2.model.dto.CreateEventRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;
import hello.mycalendarv2.model.dto.EventResponseDto;
import hello.mycalendarv2.model.entity.Event;
import hello.mycalendarv2.model.entity.User;
import hello.mycalendarv2.repository.EventRepository;
import hello.mycalendarv2.repository.UserRepository;
import hello.mycalendarv2.service.EventService;
import hello.mycalendarv2.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional
    @Override
    public void delete(Long id, DeleteRequestDto dto) {
        Event event = eventRepository.findByIdOrElseThrows(id);
        UserValidator validator = new UserValidator();

        validator.validatePassword(event.getUser().getPassword(), dto.getPassword());
        eventRepository.deleteById(id);
    }

    @Override
    public Page<EventResponseDto> findAll(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Event> pageEvent = eventRepository.findAllByOrderByUpdatedAtDesc(pageRequest);

        return pageEvent.map(EventResponseDto::new);
    }
}

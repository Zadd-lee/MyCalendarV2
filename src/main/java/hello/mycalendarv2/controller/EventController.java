package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CreateEventRequestDto;
import hello.mycalendarv2.model.dto.DeleteEventRequestDto;
import hello.mycalendarv2.model.dto.EventResponseDto;
import hello.mycalendarv2.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDto> create(
            @Validated @RequestBody CreateEventRequestDto dto
    ) {
        EventResponseDto eventResponseDto = eventService.createEvent(dto);
        return new ResponseEntity<>(eventResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> findById(@PathVariable Long id) {
        EventResponseDto dto = eventService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @Validated @RequestBody DeleteEventRequestDto dto) {
        eventService.delete(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

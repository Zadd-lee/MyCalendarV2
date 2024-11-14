package hello.mycalendarv2.controller;

import hello.mycalendarv2.model.dto.CreateEventRequestDto;
import hello.mycalendarv2.model.dto.DeleteRequestDto;
import hello.mycalendarv2.model.dto.EventResponseDto;
import hello.mycalendarv2.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @Validated @RequestBody DeleteRequestDto dto) {
        eventService.delete(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<EventResponseDto>> findAll(@RequestParam("page")int page,
                                                          @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize) {
        Page<EventResponseDto> eventResponseDtoPage = eventService.findAll(page, pageSize);
        return new ResponseEntity<>(eventResponseDtoPage, HttpStatus.OK);
    }

}

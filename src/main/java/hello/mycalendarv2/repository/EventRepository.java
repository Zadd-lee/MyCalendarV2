package hello.mycalendarv2.repository;

import hello.mycalendarv2.model.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    default Event findByIdOrElseThrows(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다"));

    }

    Page<Event> findAllByOrderByUpdatedAtDesc(PageRequest pageRequest);
}

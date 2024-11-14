package hello.mycalendarv2.repository;

import hello.mycalendarv2.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    default Comment findByIdOrElseThrows(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다"));
    }

}

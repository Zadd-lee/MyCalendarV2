package hello.mycalendarv2.repository;

import hello.mycalendarv2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    default User findByIdOrElseThrows(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다"));
    }
}

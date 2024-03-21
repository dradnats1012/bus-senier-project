package koreatechBus.repository;

import koreatechBus.domain.Bookmark;
import koreatechBus.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findBySchoolId(String schoolId);

    Boolean existsBySchoolId(String schoolId);

    Boolean existsByEmail(String email);
}

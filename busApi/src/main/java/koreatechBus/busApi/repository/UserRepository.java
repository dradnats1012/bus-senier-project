package koreatechBus.busApi.repository;

import koreatechBus.busApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findBySchoolId(String schoolId);

    Boolean existsBySchoolId(String schoolId);

    Boolean existsByEmail(String email);
}

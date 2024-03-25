package koreatechBus.repository;

import koreatechBus.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Bookmark save(Bookmark bookmark);
}

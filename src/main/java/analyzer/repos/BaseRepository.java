package analyzer.repos;

import java.util.Optional;

import analyzer.domain.models.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {
    Optional<Base> findById(Long id);
}

package in.mandadi.practice.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, UUID> {

    Long countByVisitTimeGreaterThan(LocalDateTime ts);
}

package lab1.project.repository;

import lab1.project.entity.GradeComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeComponentRepository extends JpaRepository<GradeComponent, Long> {
}

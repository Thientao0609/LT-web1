package lab1.project.repository;

import lab1.project.entity.GradeScale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeScaleRepository extends JpaRepository<GradeScale, Long> {
}

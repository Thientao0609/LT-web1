package grade_cales.studentmanager.repository;

import grade_cales.studentmanager.entity.GradeScale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface GradeScaleRepository extends JpaRepository<GradeScale, UUID> {

    Optional<GradeScale> findByMinScoreLessThanEqualAndMaxScoreGreaterThanEqualAndIsActiveTrue(
            BigDecimal score1, BigDecimal score2
    );
}
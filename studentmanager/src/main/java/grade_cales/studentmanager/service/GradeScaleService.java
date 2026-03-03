package grade_cales.studentmanager.service;

import grade_cales.studentmanager.entity.GradeScale;
import grade_cales.studentmanager.repository.GradeScaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GradeScaleService {

    private final GradeScaleRepository repository;

    public List<GradeScale> getAll() {
        return repository.findAll();
    }

    public GradeScale create(GradeScale gradeScale) {
        gradeScale.setCreatedAt(LocalDateTime.now());
        gradeScale.setIsActive(true);
        return repository.save(gradeScale);
    }

    public GradeScale getByScore(BigDecimal score) {
        return repository
                .findByMinScoreLessThanEqualAndMaxScoreGreaterThanEqualAndIsActiveTrue(score, score)
                .orElseThrow(() -> new RuntimeException("No grade found"));
    }
}
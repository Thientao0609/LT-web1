package grade_cales.studentmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "grade_scales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeScale {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal minScore;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal maxScore;

    @Column(nullable = false, length = 5)
    private String letterGrade;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal gradePoint;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UUID createdBy;
    private UUID updatedBy;

    private LocalDateTime deletedAt;
    private UUID deletedBy;

    private Boolean isActive;
}
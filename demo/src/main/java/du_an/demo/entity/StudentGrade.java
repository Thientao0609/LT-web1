package du_an.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_grades")
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @Column(name = "midterm_score")
    private BigDecimal midtermScore;

    @Column(name = "assignment_score")
    private BigDecimal assignmentScore;

    @Column(name = "final_score")
    private BigDecimal finalScore;

    @Column(name = "total_score", insertable = false, updatable = false)
    private BigDecimal totalScore;

    @Column(name = "letter_grade", insertable = false, updatable = false)
    private String letterGrade;

    @Column(name = "result", insertable = false, updatable = false)
    private String result;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // getters & setters
}
package lab1.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_grades")
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private GradeComponent component;

    private Double score;

    // getter setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public GradeComponent getComponent() { return component; }
    public void setComponent(GradeComponent component) { this.component = component; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
}

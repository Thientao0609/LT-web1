package lab1.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade_scales")
public class GradeScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minScore;
    private Double maxScore;
    private String letter;

    // getter setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getMinScore() { return minScore; }
    public void setMinScore(Double minScore) { this.minScore = minScore; }

    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }

    public String getLetter() { return letter; }
    public void setLetter(String letter) { this.letter = letter; }
}

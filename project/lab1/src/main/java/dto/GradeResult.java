package lab1.project.dto;

public class GradeResult {

    private double totalScore;
    private String letterGrade;

    public GradeResult(double totalScore, String letterGrade) {
        this.totalScore = totalScore;
        this.letterGrade = letterGrade;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public String getLetterGrade() {
        return letterGrade;
    }
}

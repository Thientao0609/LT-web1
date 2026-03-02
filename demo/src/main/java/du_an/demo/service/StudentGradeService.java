package du_an.demo.service;

import du_an.demo.entity.StudentGrade;
import du_an.demo.repository.StudentGradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGradeService {

    private final StudentGradeRepository repository;

    public StudentGradeService(StudentGradeRepository repository) {
        this.repository = repository;
    }

    public List<StudentGrade> getAll() {
        return repository.findAll();
    }

    public StudentGrade save(StudentGrade grade) {

        double total = (grade.getMidtermScore() * 0.3)
                + (grade.getAssignmentScore() * 0.2)
                + (grade.getFinalScore() * 0.5);

        grade.setTotalScore(total);

        if (total >= 8) {
            grade.setLetterGrade("A");
            grade.setResult("Pass");
        } else if (total >= 6.5) {
            grade.setLetterGrade("B");
            grade.setResult("Pass");
        } else if (total >= 5) {
            grade.setLetterGrade("C");
            grade.setResult("Pass");
        } else {
            grade.setLetterGrade("D");
            grade.setResult("Fail");
        }

        return repository.save(grade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
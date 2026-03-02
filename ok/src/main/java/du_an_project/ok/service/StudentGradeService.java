package du_an_project.ok.service;

import du_an_project.ok.entity.StudentGrade;
import du_an_project.ok.repository.StudentGradeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentGradeService {

    private final StudentGradeRepository repository;

    public StudentGradeService(StudentGradeRepository repository) {
        this.repository = repository;
    }

    public StudentGrade save(StudentGrade grade) {

        // Nếu có finalScore thì tự động tính gradeLetter
        if (grade.getFinalScore() != null) {

            double score = grade.getFinalScore();

            if (score >= 8.5) grade.setGradeLetter("A");
            else if (score >= 7) grade.setGradeLetter("B");
            else if (score >= 5.5) grade.setGradeLetter("C");
            else if (score >= 4) grade.setGradeLetter("D");
            else grade.setGradeLetter("F");
        }

        // Mặc định trạng thái
        if (grade.getStatus() == null) {
            grade.setStatus("Đã nhập");
        }

        // Audit
        grade.setIsActive(true);
        grade.setCreatedAt(LocalDateTime.now());

        return repository.save(grade);
    }

    public List<StudentGrade> getAll() {
        return repository.findAll();
    }
}
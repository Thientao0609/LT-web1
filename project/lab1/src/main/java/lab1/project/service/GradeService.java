package lab1.project.service;

import lab1.project.dto.GradeResult;
import lab1.project.entity.GradeScale;
import lab1.project.entity.StudentGrade;
import lab1.project.repository.GradeScaleRepository;
import lab1.project.repository.StudentGradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final StudentGradeRepository studentGradeRepository;
    private final GradeScaleRepository gradeScaleRepository;

    public GradeService(StudentGradeRepository studentGradeRepository,
                        GradeScaleRepository gradeScaleRepository) {
        this.studentGradeRepository = studentGradeRepository;
        this.gradeScaleRepository = gradeScaleRepository;
    }

    // ==============================
    // 1. Tính điểm tổng theo trọng số
    // ==============================
    public double calculateTotal(Long studentId) {
        List<StudentGrade> grades = studentGradeRepository.findByStudentId(studentId);

        double total = 0;
        for (StudentGrade g : grades) {
            total += g.getScore() * g.getComponent().getWeight();
        }
        return total;
    }

    // ==============================
    // 2. Đổi điểm số -> điểm chữ
    // ==============================
    public String convertToLetter(double total) {
        List<GradeScale> scales = gradeScaleRepository.findAll();

        for (GradeScale s : scales) {
            if (total >= s.getMinScore() && total <= s.getMaxScore()) {
                return s.getLetter();
            }
        }
        return "N/A";
    }

    // ==============================
    // 3. Lấy kết quả hoàn chỉnh
    // ==============================
    public GradeResult getStudentResult(Long studentId) {
        double total = calculateTotal(studentId);
        String letter = convertToLetter(total);
        return new GradeResult(total, letter);
    }
}

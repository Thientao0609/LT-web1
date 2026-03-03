package buoi1.nguyenthanhthien1.service;

import org.springframework.stereotype.Service;
import java.util.List;

import buoi1.nguyenthanhthien1.model.Student;
import buoi1.nguyenthanhthien1.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Lấy tất cả
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Tìm theo tên
    public List<Student> searchByName(String keyword) {
        return studentRepository.findByNameContainingIgnoreCase(keyword);
    }

    // Thêm hoặc sửa
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Xóa
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    // Lấy theo ID
    public Student getById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
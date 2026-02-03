package buoi1.nguyenthanhthien1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buoi1.nguyenthanhthien1.model.Student;
import buoi1.nguyenthanhthien1.repository.StudentRepository;

@Service
public class StudentService {

   @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public List<Student> searchByName(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}

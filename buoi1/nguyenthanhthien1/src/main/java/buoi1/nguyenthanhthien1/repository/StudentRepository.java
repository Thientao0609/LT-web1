package buoi1.nguyenthanhthien1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import buoi1.nguyenthanhthien1.model.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Tìm theo tên (không phân biệt hoa thường)
    List<Student> findByNameContainingIgnoreCase(String keyword);

}
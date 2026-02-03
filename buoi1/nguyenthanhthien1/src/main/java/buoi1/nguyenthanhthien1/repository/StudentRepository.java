package buoi1.nguyenthanhthien1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import buoi1.nguyenthanhthien1.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // 🔍 Tìm sinh viên theo tên (LIKE %keyword%)
    List<Student> findByNameContainingIgnoreCase(String keyword);
}

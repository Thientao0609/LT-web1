package buoi1.nguyenthanhthien1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import buoi1.nguyenthanhthien1.model.Student;
import buoi1.nguyenthanhthien1.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // cho phép gọi từ HTML/JS
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 📌 LẤY DANH SÁCH + TÌM KIẾM
    @GetMapping
    public List<Student> getStudents(
            @RequestParam(required = false) String keyword) {

        if (keyword != null && !keyword.trim().isEmpty()) {
            return studentService.searchByName(keyword);
        }
        return studentService.getAllStudents();
    }

    // 📌 THÊM MỚI
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // 📌 CẬP NHẬT
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {

        student.setId(id);
        return studentService.save(student);
    }

    // 📌 XÓA
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
    }
}

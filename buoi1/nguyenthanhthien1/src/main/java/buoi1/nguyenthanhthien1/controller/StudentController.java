package buoi1.nguyenthanhthien1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import buoi1.nguyenthanhthien1.model.Student;
import buoi1.nguyenthanhthien1.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // HIỂN THỊ DANH SÁCH (Sửa tại đây)
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", service.getAllStudents());
        // Thêm dòng này để Form thêm nhanh ở trang students.html không bị lỗi
        model.addAttribute("student", new Student()); 
        return "students";
    }

    // Mở form thêm (Trang riêng)
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    // Mở form sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("student", student);
        return "form";
    }

    // Lưu (thêm + sửa)
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/students";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/students";
    }
}
package buoi1.nguyenthanhthien1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import buoi1.nguyenthanhthien1.model.Student;
import buoi1.nguyenthanhthien1.service.StudentService;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(required = false) String keyword) {

        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("students",
                    studentService.searchByName(keyword));
        } else {
            model.addAttribute("students",
                    studentService.getAllStudents());
        }

        return "students";
    }
}
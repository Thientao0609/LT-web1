package du_an_project.ok.controller;

import du_an_project.ok.entity.StudentGrade;
import du_an_project.ok.service.StudentGradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/grades")
public class StudentGradeController {

    private final StudentGradeService service;

    public StudentGradeController(StudentGradeService service) {
        this.service = service;
    }

    @PostMapping
    public StudentGrade create(@RequestBody StudentGrade grade) {
        return service.save(grade);
    }

    @GetMapping
    public List<StudentGrade> getAll() {
        return service.getAll();
    }
}
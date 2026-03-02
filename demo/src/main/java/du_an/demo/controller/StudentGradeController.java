package du_an.demo.controller;

import du_an.demo.entity.StudentGrade;
import du_an.demo.repository.StudentGradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin
public class StudentGradeController {

    private final StudentGradeRepository repository;

    public StudentGradeController(StudentGradeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<StudentGrade> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public StudentGrade create(@RequestBody StudentGrade grade) {
        return repository.save(grade);
    }
}
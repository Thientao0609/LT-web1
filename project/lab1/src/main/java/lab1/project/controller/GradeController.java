package lab1.project.controller;

import lab1.project.service.GradeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService service;

    public GradeController(GradeService service) {
        this.service = service;
    }

    @GetMapping("/{studentId}/total")
    public double total(@PathVariable Long studentId) {
        return service.calculateTotal(studentId);
    }

    @GetMapping("/{studentId}/letter")
    public String letter(@PathVariable Long studentId) {
        double total = service.calculateTotal(studentId);
        return service.convertToLetter(total);
    }
}

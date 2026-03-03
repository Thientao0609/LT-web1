package grade_cales.studentmanager.controller;

import grade_cales.studentmanager.entity.GradeScale;
import grade_cales.studentmanager.service.GradeScaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/grade-scales")
@RequiredArgsConstructor
public class GradeScaleController {

    private final GradeScaleService service;

    @GetMapping
    public List<GradeScale> getAll() {
        return service.getAll();
    }

    @PostMapping
    public GradeScale create(@RequestBody GradeScale gradeScale) {
        return service.create(gradeScale);
    }

    @GetMapping("/by-score")
    public GradeScale getByScore(@RequestParam BigDecimal score) {
        return service.getByScore(score);
    }
}
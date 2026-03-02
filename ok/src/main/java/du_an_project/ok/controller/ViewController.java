package du_an_project.ok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/grades")
    public String showGrades() {
        return "grades";
    }
}
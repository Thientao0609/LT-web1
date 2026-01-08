package buoi1.nguyenthanhthien1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Nguyenthanhthien1Application {

	public static void main(String[] args) {
		SpringApplication.run(Nguyenthanhthien1Application.class, args);
	}
	@GetMapping("/hello")
	public String hello() {
		return "Hello ST23A";
	}
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "Hello " + name;
	}
	@GetMapping("/students/search")
	public String search(
			@RequestParam String Keyword,
			@RequestParam(defaultValue = "1")int page){
		return "Keyword="+Keyword +",page="+page;
		}
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable int id){
		return "sinh viên có mã:"+id;
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
    List<Student> list = new ArrayList<>();
    list.add(new Student(1, "Nguyễn Văn A", 20));
    list.add(new Student(2, "Trần Văn B", 21));
    return list;
}

}

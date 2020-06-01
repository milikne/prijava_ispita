package rs.tfzr.prijavaIspita.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.tfzr.prijavaIspita.model.Student;
import rs.tfzr.prijavaIspita.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/studenti")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PreAuthorize("hasAnyRole('ZAPOSLENI', 'STUDENT')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") Long id) {
        Student student = studentService.findOne(id);
        if (student == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@Valid @RequestBody Student student) {
        return studentService.save(student);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(method = RequestMethod.PUT)
    public Student put(@Valid @RequestBody Student student) {
        return studentService.save(student);
    }
}

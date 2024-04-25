package com.example.TP4.Controller;

import com.example.TP4.Entity.Student;
import com.example.TP4.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student students) {
        studentServices.saveUpdate(students);
        return students.getid();

    }
    @GetMapping(value = "/getAll")
    private Iterable<Student>getStudents() {
        return studentServices.listAll();

    }
    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student,@PathVariable(name = "id")String id) {
        student.setid(id);
        studentServices.saveUpdate(student);
        return student;

    }
    @DeleteMapping(value = "/delete/{id}")
    private void deleteStudent(@PathVariable(name = "id")String id) {
        studentServices.deleteStudent(id);
    }
    @RequestMapping(value = "/student/{id}")
    private Student getStudent(@PathVariable(name = "id")String studentid) {
        return studentServices.getStudentByID(studentid);
    }


}

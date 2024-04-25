package com.example.TP4.Service;

import com.example.TP4.Entity.Student;
import com.example.TP4.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
    @Autowired
    private StudentRepo repo;
    public void saveUpdate(Student students) {
        repo.save(students);
    }

    public Iterable<Student> listAll() {
        return repo.findAll();
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }

    public Student getStudentByID(String studentid) {
        return repo.findById(studentid).get();
    }
}

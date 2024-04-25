package com.example.TP4;

import com.example.TP4.Entity.Student;
import com.example.TP4.Repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Tp4Application.class)
@ExtendWith(SpringExtension.class)
class TestUnitaire {
    @Autowired
    StudentRepo repository;
    @Test
    void contextLoads() {
    }
    @Test
    public void testRepository(){
       Student c =new Student();
        c.setAddresse("tunis");
        c.setName("Adel");
        c.setPhone("123456789");
        repository.save(c);
        assertEquals( 6 ,repository.findAll().size());
        Student loadedClient = repository.findById(c.getid()).get();
        assertEquals("Adel", loadedClient.getName());
        assertEquals("tunis", loadedClient.getAddresse());
        assertEquals("123456789", loadedClient.getPhone());
        c.setName("Adel");
        repository.save(c);
        Student updatedClient = repository.findById(c.getid()).get();
        assertEquals("Mourad", updatedClient.getName());
        assertEquals("tunis", updatedClient.getAddresse());
        assertEquals("123456789", loadedClient.getPhone());
        repository.delete(c);
        assertEquals( 5 ,repository.findAll().size());
    }
}
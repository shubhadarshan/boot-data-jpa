package in.spdev.boot.datajpa.springbootdatajpagenerators;

import in.spdev.boot.datajpa.springbootdatajpagenerators.entities.Student;
import in.spdev.boot.datajpa.springbootdatajpagenerators.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDatajpaGeneratorsApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {

    }

    @Test
    public void saveStudent(){
        Student student = new Student(1,"spdev","dev@gmail.com",26);
        studentRepository.save(student);
    }

    @Test
    public void saveAnotherStudent(){
        Student student = new Student(2,"maan","abhi@gmail.com",27);
        studentRepository.save(student);
    }
}

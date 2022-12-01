package in.spdev;

import in.spdev.entity.Guardian;
import in.spdev.entity.Student;
import in.spdev.generators.StudentPKID;
import in.spdev.repository.AnnotationsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootDatajpaAnnotationsApplicationTests {

    @Autowired
    private AnnotationsRepository annotationsRepository;

    @Test
    public void insertStudent() {
        StudentPKID studentPKID = StudentPKID.builder().name("vjc").build();
        Guardian guardian = Guardian.builder()
                .guardianName("Jimmy")
                .guardianPhone("9978909876")
                .address("New jersey")
                .pin(433434)
                .locality("town hall")
                .build();
        Student student = Student.builder()
                .studentId(studentPKID)
                .studentName("Joey")
                .standard("1st")
                .guardian(guardian)
                .build();

        Student savedStudent = annotationsRepository.save(student);
        System.out.println(savedStudent);
    }

}

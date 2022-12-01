package in.spdev.repository;

import in.spdev.entity.Student;
import in.spdev.generators.StudentPKID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnotationsRepository extends JpaRepository<Student, StudentPKID> {}

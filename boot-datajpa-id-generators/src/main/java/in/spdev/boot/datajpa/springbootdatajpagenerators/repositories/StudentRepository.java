package in.spdev.boot.datajpa.springbootdatajpagenerators.repositories;

import in.spdev.boot.datajpa.springbootdatajpagenerators.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
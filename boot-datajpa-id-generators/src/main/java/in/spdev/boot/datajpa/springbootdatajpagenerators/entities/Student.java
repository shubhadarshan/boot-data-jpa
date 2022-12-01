package in.spdev.boot.datajpa.springbootdatajpagenerators.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student_dtls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "std_seq_gen", sequenceName = "std_seq_gen", allocationSize = 1, initialValue = 1, schema = "spring_data")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "std_seq_gen")
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_age")
    private Integer studentAge;
}

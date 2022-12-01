package in.spdev.entity;

import in.spdev.generators.StudentPKID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_students",schema = "spring_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @EmbeddedId
    private StudentPKID studentId;
    private String studentName;
    private String standard;

    @Embedded
    private Guardian guardian;
}

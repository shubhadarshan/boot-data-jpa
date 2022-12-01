package in.spdev.bootcompositepkemployeeservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employees", schema = "spring_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmployeePKID.class)
public class Employee {
    @Id
    private int employeeId;
    @Id
    private String deptName;
    private String name;
    private String email;
    private String phone;
}

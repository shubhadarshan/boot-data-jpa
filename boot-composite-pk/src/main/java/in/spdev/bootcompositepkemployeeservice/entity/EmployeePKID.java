package in.spdev.bootcompositepkemployeeservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @developer : shubhadarshan
 * @apiNote : if we are using composite PK & implementing through ID class/Embedded ID we
 * must implement from {@link Serializable} & override Equals & hashcode methods.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeePKID implements Serializable {
    private int employeeId;
    private String deptName;
}

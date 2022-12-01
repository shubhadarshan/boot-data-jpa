package in.spdev.bootcompositepkemployeeservice.repository;

import in.spdev.bootcompositepkemployeeservice.entity.Employee;
import in.spdev.bootcompositepkemployeeservice.entity.EmployeePKID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeePKID> {
}
package in.spdev.bootcompositepkemployeeservice;

import in.spdev.bootcompositepkemployeeservice.entity.Customer;
import in.spdev.bootcompositepkemployeeservice.entity.CustomerPKID;
import in.spdev.bootcompositepkemployeeservice.entity.Employee;
import in.spdev.bootcompositepkemployeeservice.repository.CustomerRepository;
import in.spdev.bootcompositepkemployeeservice.repository.EmployeeRepository;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BootCompositePkEmployeeServiceApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveEmployee(){
//        Employee employee = new Employee(1,"dev","sp","sp@gmail.com","8789076541");
        Employee employee = new Employee(1,"HR","sp","sp@gmail.com","8789076541");
        employeeRepository.save(employee);
    }

    @Test
    public void saveCustomer(){
        Customer customer = new Customer(new CustomerPKID(2,"bbsr"),
                "sp","a-vihar","sp@gmail.com");
        customerRepository.save(customer);
    }
}

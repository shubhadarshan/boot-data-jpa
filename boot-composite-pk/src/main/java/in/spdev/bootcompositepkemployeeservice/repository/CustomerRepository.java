package in.spdev.bootcompositepkemployeeservice.repository;

import in.spdev.bootcompositepkemployeeservice.entity.Customer;
import in.spdev.bootcompositepkemployeeservice.entity.CustomerPKID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerPKID> {}

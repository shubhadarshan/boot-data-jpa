package in.spdev.boot.springbootdatajpacustomgenerators.repository;

import in.spdev.boot.springbootdatajpacustomgenerators.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface OrderRepository extends JpaRepository<OrderDetailsEntity, Serializable> {
}
package in.spdev.boot.springbootdatajpacustomgenerators.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
public class OrderDetailsEntity {
    @Id
    @Column(name = "order_id")
    @GenericGenerator(
            name = "cust_gen",
            strategy = "in.spdev.boot.springbootdatajpacustomgenerators.generators.OrderIdGenerator")
    @GeneratedValue(generator = "cust_gen")
    protected String orderId; //ibm1 ibm2 etc
    @Column(name = "order_by")
    protected String orderBy;
    @Column(name = "order_placed_date")
    @CreationTimestamp
    protected Date orderPlacedDate;

    public OrderDetailsEntity(String orderBy) {
        this.orderPlacedDate = orderPlacedDate;
    }
}



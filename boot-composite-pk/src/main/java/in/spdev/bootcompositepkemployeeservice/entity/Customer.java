package in.spdev.bootcompositepkemployeeservice.entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tbl_customers",schema = "spring_data")
@NoArgsConstructor
public class Customer {
    @EmbeddedId
    private CustomerPKID customerPKID;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    @CreationTimestamp
    private Date entry;
    @UpdateTimestamp
    private Date lastVisited;

    public Customer(CustomerPKID customerPKID, String customerName, String customerAddress, String customerEmail) {
        this.customerPKID = customerPKID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }
}

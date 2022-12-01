package in.spdev.akit.boot.persistence.springbootdatajpaakit.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contacts_master")
public class ContactsMasterEntity {
    @Id
    @Column(name = "contact_id")
    private int contactId;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contactNumber")
    private long contact_number;
}

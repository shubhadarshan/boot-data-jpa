package in.spdev.bootcompositepkemployeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerPKID implements Serializable {
    private int customerNo;
    private String mallBranch;
}

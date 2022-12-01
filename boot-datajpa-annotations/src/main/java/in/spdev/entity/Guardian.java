package in.spdev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "guardianName",column = @Column(name = "guardian_name")),
        @AttributeOverride(name = "guardianPhone",column = @Column(name = "guardian_phone")),
})
public class Guardian {
    private String guardianName;
    private String guardianPhone;
    private String address;
    private int pin;
    private String locality;
}

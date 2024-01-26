package dani.cortelcomback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private PaymentMethod paymentMethod;

    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollmentDate;

    private Boolean isActive;

}

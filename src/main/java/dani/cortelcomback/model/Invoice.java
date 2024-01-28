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
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Service service;

    private Double amount_billed;

    @Temporal(TemporalType.TIMESTAMP)
    private Date generationDate;

    @Temporal(TemporalType.DATE)
    private Date payment_limit_date;

}

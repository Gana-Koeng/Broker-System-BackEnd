package csx.broker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//create table and variable match to database
@Entity
@Setter
@Getter
@Data
@Table(name = "Broker")
public class Broker {

    @Id
    @Column(name= "ID",columnDefinition = "Int NOT NULL")
    private int id;

    @Column(name= "Sell",columnDefinition = "Int")
    private Integer sell;

    @Column(name= "Price",columnDefinition = "Int")
    private Integer price;
}

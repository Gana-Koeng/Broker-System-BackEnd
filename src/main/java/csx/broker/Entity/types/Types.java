package csx.broker.Entity.types;

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
@Table(name = "type_order")

public class Types {

    @Id
    @Column(name= "order_type",columnDefinition = "String")
    private String OrderType;
    @Column(name= "order_name",columnDefinition = "String")
    private String OrderName;


}

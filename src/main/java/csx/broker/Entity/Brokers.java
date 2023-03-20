package csx.broker.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

//create table and variable match to database
@Entity
@Setter
@Getter
@Data
@Table(name = "brokers")

public class Brokers {

    @Id
    @Column(name= "broker_id",columnDefinition = "Int")
    private int BrokerId;
    @Column(name= "broker_name",columnDefinition = "String")
    private String BrokerName;


}

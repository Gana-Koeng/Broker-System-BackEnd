package csx.broker.Entity.recently;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

//create table and variable match to database
@Entity
@Setter
@Getter
@Data
@Table(name = "recently")

public class Recently {

    @Id
    @Column(name= "id",columnDefinition = "Int")
    private int id;
    @Column(name= "time",columnDefinition = "Time")
    private Time time;
    @Column(name= "execution_price",columnDefinition = "Int")
    private int executionPrice;
    @Column(name= "change",columnDefinition = "Int")
    private int change;
    @Column(name= "change_percentage",columnDefinition = "Int")
    private int changePercentage;
    @Column(name= "trade_volume",columnDefinition = "Int")
    private int tradeVolume;
    @Column(name= "trade_value",columnDefinition = "Int")
    private int tradeValue;

}

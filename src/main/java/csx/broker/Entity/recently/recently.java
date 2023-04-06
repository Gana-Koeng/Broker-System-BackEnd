package csx.broker.Entity.recently;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Data
@Table(name = "recently")
public class recently {

    @Id
    @Column(name= "id",columnDefinition = "Int")
    private int  id;
    @Column(name= "time",columnDefinition = "Time")
    private int time;
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

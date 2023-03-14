package csx.broker.Entity;

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
@Table(name = "tradeinfo")
public class TradeInfo {

    @Id
    @Column(name= "idtime",columnDefinition = "INT")
    private int time;

    @Column(name= "executionprice",columnDefinition = "FLOAT")
    private String execution_price;
    @Column(name= "numchange",columnDefinition = "INT")
    private String change;
    @Column(name= "percentchange",columnDefinition = "INT")
    private String change_;
    @Column(name= "tradevolume",columnDefinition = "INT")
    private String trade_volume;
    @Column(name= "tradevalue",columnDefinition = "INT")
    private String trade_value;
}

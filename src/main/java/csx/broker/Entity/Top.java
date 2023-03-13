package csx.broker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data

@Table(name = "Buy")
public class Top {
    @Id
    @Column(name= "ID",columnDefinition = "Int NOT NULL")
    private int id;

    @Column(name= "Sell",columnDefinition = "Int")
    private Integer sell;

    @Column(name= "Sell_Quality",columnDefinition = "Int")
    private Integer sell_quality;

    @Column(name= "Price",columnDefinition = "Int")
    private Integer price;

    @Column(name= "Buy",columnDefinition = "Int")
    private Integer buy;
     @Column(name= "Buy_Quality",columnDefinition = "Int")
    private Integer buy_quality;


}

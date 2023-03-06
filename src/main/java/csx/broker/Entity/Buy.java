package csx.broker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
public class Buy {
    @Id
    @Column(name= "ID",columnDefinition = "Int NOT NULL")
    private int id;

    @Column(name= "Sell",columnDefinition = "INT")
    private String sell;
    @Column(name= "Price",columnDefinition = "FLOAT")
    private String price;
    @Column(name= "Buy",columnDefinition = "INT")
    private String buy;
}

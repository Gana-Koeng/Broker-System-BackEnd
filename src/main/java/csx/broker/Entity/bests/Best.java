package csx.broker.Entity.bests;

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
@Table(name = "best_price")

public class Best {

    @Id
    @Column(name= "id",columnDefinition = "Int")
    private int id;
    @Column(name= "best_type",columnDefinition = "String")
    private String bestType;
    @Column(name= "best_stock",columnDefinition = "String")
    private String BestStock;
    @Column(name= "best_uv",columnDefinition = "Int")
    private int BestUV;
    @Column(name= "best_qty",columnDefinition = "int")
    private String BestQty;


}

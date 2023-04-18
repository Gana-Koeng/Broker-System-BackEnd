package csx.broker.Entity.bests;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
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
    @Column(name = "id", columnDefinition = "Int")
    private int id;
    @Column(name = "order_type", columnDefinition = "int")
    private int orderType;
    @Column(name = "order_stock", columnDefinition = "int")
    private int orderStock;
    @Column(name = "order_uv", columnDefinition = "Int")
    private int orderUv;
    @Column(name = "order_qty", columnDefinition = "int")
    private int orderQty;



}


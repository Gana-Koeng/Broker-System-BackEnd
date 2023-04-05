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
@Table(name = "best_price")
public class QuotationData {


    @Id
    @Column(name = "id", columnDefinition = "Int")
    private int id;
    @Column(name = "order_type", columnDefinition = "String")
    private String orderType;
    @Column(name = "order_stock", columnDefinition = "String")
    private String orderStock;
    @Column(name = "order_uv", columnDefinition = "Int")
    private int orderUv;
    @Column(name = "order_qty", columnDefinition = "int")
    private int orderQty;


    public String getData() {

        return null;
    }
}


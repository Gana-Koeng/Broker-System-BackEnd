package csx.broker.Entity.orders;

//import csx.broker.Entity.broker.BrokerId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;

//create table and variable match to database
@Entity
@Setter
@Getter
@Data
@Table(name = "table_order")
@IdClass(OrderID.class)
public class Order implements Serializable {

    @Id
    @Column(name= "order_no",columnDefinition = "Int")
    private int orderNo;

    @Id
    @Column(name= "order_date",columnDefinition = "Date")
    private Date orderDate;

    @Id
    @Column(name= "broker_id",columnDefinition = "String")
    private String brokerId;
    @Column(name= "account_no",columnDefinition = "String")
    private String accountNo;
    @Column(name= "order_type",columnDefinition = "int")
    private int orderType;
    @Column(name= "issue_code",columnDefinition = "String")
    private String issueCode;
    @Column(name= "original_order_no",columnDefinition = "Int")
    private int originalOrderNo;
    @Column(name= "order_qty",columnDefinition = "Int")
    private int orderQty;
    @Column(name= "order_uv",columnDefinition = "BigInt")
    private BigInteger orderUV;
    @Column(name= "remain_qty",columnDefinition = "String")
    private String remainQty;
//    List<Broker> list = new ArrayList<>();
}

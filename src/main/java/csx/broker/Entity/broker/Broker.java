package csx.broker.Entity.broker;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Setter
@Getter
@Data
@Table(name = "table_order")
@IdClass(BrokerId.class)
public class Broker implements Serializable {

    @Id
    @Column(name= "order_no",columnDefinition = "Auto Increment")
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
    @Column(name= "issue_code",columnDefinition = "int")
    private int issueCode;
    @Column(name= "original_order_no",columnDefinition = "Int")
    private int originalOrderNo;
    @Column(name= "order_qty",columnDefinition = "Int")
    private int orderQty;
    @Column(name= "order_uv",columnDefinition = "BigInt")
    private BigInteger orderUV;

//    List<Broker> list = new ArrayList<>();



}

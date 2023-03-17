package csx.broker.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

//create table and variable match to database
@Entity
@Setter
@Getter
@Data
@Table(name = "table_order")
@IdClass(BrokerId.class)
public class Broker implements Serializable {

    @Id
    @Column(name= "order_no",columnDefinition = "Int")
    private int OrderNo;

    @Id
    @Column(name= "order_date",columnDefinition = "Date")
    private Date OrderDate;

    @Id
    @Column(name= "broker_id",columnDefinition = "String")
    private String BrokerId;

    @Column(name= "account_no",columnDefinition = "String")
    private String AccountNo;
    @Column(name= "order_type",columnDefinition = "String")
    private String OrderType;
    @Column(name= "issue_code",columnDefinition = "String")
    private String IssueCode;
    @Column(name= "original_order_no",columnDefinition = "Int")
    private int OriginalOrderNo;
    @Column(name= "order_qty",columnDefinition = "Int")
    private int OrderQty;
    @Column(name= "order_uv",columnDefinition = "BigInt")
    private BigInteger OrderUV;


}

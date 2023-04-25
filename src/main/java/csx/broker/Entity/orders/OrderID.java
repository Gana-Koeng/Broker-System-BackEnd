package csx.broker.Entity.orders;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class OrderID implements Serializable {

    private int orderNo;
    private Date orderDate;
    private String brokerId;
}

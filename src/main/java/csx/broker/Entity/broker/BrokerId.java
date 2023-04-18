package csx.broker.Entity.broker;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class BrokerId implements Serializable {

    private int orderNo;
    private Date orderDate;
    private String brokerId;
}

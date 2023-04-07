package csx.broker.Entity.broker;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class BrokerId implements Serializable {

    private int orderNo;
    private Date orderDate;
    private String brokerId;
}

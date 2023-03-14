package csx.broker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class BrokerId implements Serializable {

    private int OrderNo;
    private Date OrderDate;
    private String BrokerId;
}

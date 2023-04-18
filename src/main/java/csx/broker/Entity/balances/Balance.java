package csx.broker.Entity.balances;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter
@Getter
@Data
@Table(name = "balance")
public class Balance {

    @Id
    @Column(name= "account_no",columnDefinition = "String")
    private String accountNo;
    @Column(name= "balance",columnDefinition = "Int")
    private int balance;
    @Column(name= "date",columnDefinition = "Date")
    private Date date;
    @Column(name= "amount",columnDefinition = "int")
    private int amount;
    @Column(name= "status",columnDefinition = "string")
    private String status;

}

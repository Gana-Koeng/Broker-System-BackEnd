package csx.broker.Entity.balances;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Data
@Table(name = "balance")
public class Balance {

    @Id
    @Column(name= "account_no",columnDefinition = "String")
    private String account_no;
    @Column(name= "balance",columnDefinition = "Int")
    private int balance;

    @Column(name= "date",columnDefinition = "String")
    private String date;
    @Column(name= "status",columnDefinition = "String")
    private String status;
}

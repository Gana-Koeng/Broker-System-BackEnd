package csx.broker.Entity.accounts;

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
@Table(name = "accounts")

public class Account {

    @Id
    @Column(name= "account_no",columnDefinition = "String")
    private String accountNo;

    @Column(name= "account_name",columnDefinition = "String")
    private String accountName;
    @Column(name= "type",columnDefinition = "int")
    private Integer accountType;



}

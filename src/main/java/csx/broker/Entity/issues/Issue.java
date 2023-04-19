package csx.broker.Entity.issues;

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
@Table(name = "stock")

public class Issue {

    @Id
    @Column(name= "issue_code",columnDefinition = "String")
    private String issueCode;

    @Column(name= "issue_symbol",columnDefinition = "String")
    private String issueSymbol;
    @Column(name= "issue_name",columnDefinition = "String")
    private String issueName;
    @Column(name= "issue_description",columnDefinition = "String")
    private String issueDescription;
    @Column(name= "issue_date",columnDefinition = "Date")
    private Date issueDate;


}

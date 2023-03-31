package csx.broker.Entity.balances;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "balance")
public class Balance {

    @Id
    @Column(name= "account_no",columnDefinition = "String")
    private int account_no;
    @Column(name= "balance",columnDefinition = "Int")
    private String balance;
    @Column(name= "date",columnDefinition = "Date")
    private String date;
}

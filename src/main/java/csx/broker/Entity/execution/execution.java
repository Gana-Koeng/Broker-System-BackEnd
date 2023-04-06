package csx.broker.Entity.execution;

import com.google.api.client.util.DateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Setter
@Getter
@Data
@Table(name = "execution_table")
public class execution {

    @Id
    @Column(name= "order_no",columnDefinition = "Int")
    private int  orderNo;
    @Column(name= "order_date",columnDefinition = "Date")
    private Date orderDate;
    @Column(name= "broker_id",columnDefinition = "String")
    private String brokerId;
    @Column(name= "contract_no",columnDefinition = "Int")
    private int contractNo;
    @Column(name= "order_type",columnDefinition = "String")
    private String orderType;
    @Column(name= "issue_code",columnDefinition = "String")
    private String issueCode;
    @Column(name= "contract_qty",columnDefinition = "Int")
    private int contractQty;
    @Column(name= "contract_uv",columnDefinition = "BigInt")
    private BigInteger contractUv;
    @Column(name= "contract_time",columnDefinition = "DateTime")
    private DateTime contractTime;

}

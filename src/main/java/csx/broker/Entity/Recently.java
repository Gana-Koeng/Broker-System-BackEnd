package csx.broker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name="recentlys")
public class Recently {
    @Id
    @Column(name= "id",columnDefinition = "int")
    private int Id;
    @Column(name="execute_price", columnDefinition = "int")
    private int ExecutePrice;
}

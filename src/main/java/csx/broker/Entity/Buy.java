package csx.broker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data

@Table(name = "Buy")
public class Buy {
    @Id
    @Column(name= "ID",columnDefinition = "Int NOT NULL")
    private int id;

    @Column(name= "Buy",columnDefinition = "Int")
    private Integer buy;

    @Column(name= "Price",columnDefinition = "Int")
    private Integer price;
}

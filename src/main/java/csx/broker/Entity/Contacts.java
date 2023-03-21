package csx.broker.Entity;

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
@Table(name = "contacts")

public class Contacts {

    @Id
    @Column(name= "id",columnDefinition = "Int")
    private int id;
    @Column(name= "name",columnDefinition = "String")
    private String name;
    @Column(name= "email",columnDefinition = "String")
    private String email;
    @Column(name= "message",columnDefinition = "String")
    private String message;


}

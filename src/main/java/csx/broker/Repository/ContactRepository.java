package csx.broker.Repository;

import csx.broker.Entity.Contacts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface ContactRepository extends CrudRepository<Contacts,Integer> {

    @Query(value = "SELECT * FROM order_type ", nativeQuery = true)
    Iterable<Contacts> getAllData();

}

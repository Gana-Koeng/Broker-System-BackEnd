package csx.broker.Repository;

import csx.broker.Entity.Broker;
//import csx.broker.Entity.Buy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//get all data from table broker
@Repository
public interface BrokerRepository extends CrudRepository<Broker,Integer> {

    @Query(value = "SELECT * FROM table_order ", nativeQuery = true)
    Iterable<Broker> getAllData();

}

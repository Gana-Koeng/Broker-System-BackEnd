package csx.broker.Repository;

import csx.broker.Entity.Broker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface BrokerRepository extends CrudRepository<Broker,Integer> {

    @Query(value = "SELECT * FROM Broker ", nativeQuery = true)
    Iterable<Broker> getAllData();

}

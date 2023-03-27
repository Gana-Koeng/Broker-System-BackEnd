package csx.broker.Repository.brokers;

import csx.broker.Entity.brokers.Brokers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface BrokersRepository extends CrudRepository<Brokers,Integer> {

    @Query(value = "SELECT * FROM brokers ", nativeQuery = true)
    Iterable<Brokers> getAllData();

}

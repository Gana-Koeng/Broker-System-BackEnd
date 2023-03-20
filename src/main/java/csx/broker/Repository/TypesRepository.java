package csx.broker.Repository;

import csx.broker.Entity.Types;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface TypesRepository extends CrudRepository<Types,Integer> {

    @Query(value = "SELECT * FROM order_type ", nativeQuery = true)
    Iterable<Types> getAllData();

}

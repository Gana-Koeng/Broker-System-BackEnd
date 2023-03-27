package csx.broker.Repository.types;

import csx.broker.Entity.types.Types;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface TypesRepository extends CrudRepository<Types,Integer> {

    @Query(value = "SELECT * FROM order_type ", nativeQuery = true)
    Iterable<Types> getAllData();

}

package csx.broker.Repository.recently;

import csx.broker.Entity.recently.recently;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface recentlyRepository extends CrudRepository<recently,Integer> {

    @Query(value = "SELECT * FROM recently ", nativeQuery = true)
    Iterable<recently> getAllData();

}

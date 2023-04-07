package csx.broker.Repository.recently;

import csx.broker.Entity.recently.Recently;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface RecentlyRepository extends CrudRepository<Recently,Integer> {

    @Query(value = "SELECT * FROM recently ", nativeQuery = true)
    Iterable<Recently> getAllData();

}

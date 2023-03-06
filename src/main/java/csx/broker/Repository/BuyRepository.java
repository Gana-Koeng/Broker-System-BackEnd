package csx.broker.Repository;

import csx.broker.Entity.Buy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends CrudRepository<Buy,Integer> {
    @Query(value = "SELECT * FROM Buy ", nativeQuery = true)
    Iterable<Buy> getAllData();
}

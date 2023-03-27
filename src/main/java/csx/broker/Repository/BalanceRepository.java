package csx.broker.Repository;

import csx.broker.Entity.Balance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BalanceRepository extends CrudRepository<Balance,Integer> {

    @Query(value = "SELECT * FROM balance ", nativeQuery = true)
    Iterable<Balance> getAllData();
}

package csx.broker.Repository.execution;


import csx.broker.Entity.execution.execution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface executionRepository extends CrudRepository<execution,Integer> {
    @Query(value = "SELECT * FROM execution_table ", nativeQuery = true)
    Iterable<execution> getAllData();


}

package csx.broker.Repository.execution;

//import csx.broker.Entity.broker.Broker;
import csx.broker.Entity.execution.Execution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface ExecutionRepository extends CrudRepository<Execution,Integer> {

    @Query(value = "SELECT * FROM execution ", nativeQuery = true)
    Iterable<Execution> getAllData();

//    Iterable<Execution> getAlldata();
}

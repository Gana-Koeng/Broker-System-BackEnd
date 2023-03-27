package csx.broker.Repository.bests;


import csx.broker.Entity.bests.Best;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestRepository extends CrudRepository<Best,Integer> {

    @Query(value = "SELECT * FROM best_price ", nativeQuery = true)
    Iterable<Best> getAllData();


//    void delete(String accountNo);
}

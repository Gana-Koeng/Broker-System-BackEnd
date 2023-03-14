package csx.broker.Repository;


import csx.broker.Entity.Recent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentRepository extends CrudRepository<Recent,Integer> {

    @Query(value = "SELECT * FROM Recent ", nativeQuery = true)
    Iterable<Recent> getAllData();

}

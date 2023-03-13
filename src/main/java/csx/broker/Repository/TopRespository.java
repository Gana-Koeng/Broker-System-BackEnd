package csx.broker.Repository;


import csx.broker.Entity.Top;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopRespository extends CrudRepository<Top,Integer> {

    @Query(value = "SELECT * FROM Top ", nativeQuery = true)
    Iterable<Top> getAllData();


}

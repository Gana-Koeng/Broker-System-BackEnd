package csx.broker.Repository;


import csx.broker.Entity.Recently;
import csx.broker.Entity.accounts.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentlyRespository extends CrudRepository<Recently,Integer> {

    @Query(value = "SELECT * FROM recentlys ", nativeQuery = true)
    Iterable<Recently> getAllData();

//    Iterable<Recently> getAlldata();


//    void delete(String accountNo);
}

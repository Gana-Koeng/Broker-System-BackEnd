package csx.broker.Repository.accounts;


import csx.broker.Entity.accounts.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRespository extends CrudRepository<Account,Integer> {

    @Query(value = "SELECT * FROM accounts ", nativeQuery = true)
    Iterable<Account> getAllData();


//    void delete(String accountNo);
}

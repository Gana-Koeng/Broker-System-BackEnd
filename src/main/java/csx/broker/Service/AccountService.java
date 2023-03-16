package csx.broker.Service;

import csx.broker.Entity.Account;
import csx.broker.Repository.AccountRespository;
import csx.broker.Repository.IssueRespository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRespository accountRespository;
    private AccountService(AccountRespository accountRespository) {
        this.accountRespository = accountRespository;
    }
    public Iterable<Account> getAll() {
        return accountRespository.findAll();
    }

    public Iterable<Account> getAlldata() {
        return accountRespository.getAllData();
    }


    public void save(Account account){
        accountRespository.save(account);
    }



//    public void delete(String accountNo) {
//        accountRespository.delete(accountNo);
//    }
}

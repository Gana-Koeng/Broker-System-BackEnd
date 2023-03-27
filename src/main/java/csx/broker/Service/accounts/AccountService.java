package csx.broker.Service.accounts;

import csx.broker.Entity.accounts.Account;
import csx.broker.Repository.accounts.AccountRespository;
//import csx.broker.Repository.issues.IssueRespository;
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

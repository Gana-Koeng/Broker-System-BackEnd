package csx.broker.Service.balances;

import csx.broker.Entity.balances.Balance;

<<<<<<< HEAD:src/main/java/csx/broker/Service/balances/BalanceService.java
import csx.broker.Repository.balances.BalanceRepository;
=======
import csx.broker.Entity.accounts.Account;
import csx.broker.Repository.BalanceRepository;
>>>>>>> 645dfbcf209d7aba0c1c1c933b755762be29cdac:src/main/java/csx/broker/Service/BalanceService.java

import org.springframework.stereotype.Service;


@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }


    public Iterable<Balance> getAlldata() {
        return balanceRepository.findAll();
    }
    public void save(Balance balance){
        balanceRepository.save(balance);
    }

}

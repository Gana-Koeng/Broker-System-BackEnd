package csx.broker.Service.balances;
import csx.broker.Entity.balances.Balance;
import csx.broker.Repository.balances.BalanceRepository;
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

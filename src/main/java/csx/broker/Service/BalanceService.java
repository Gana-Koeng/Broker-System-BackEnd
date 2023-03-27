package csx.broker.Service;

import csx.broker.Entity.Balance;

import csx.broker.Repository.BalanceRepository;

import org.springframework.stereotype.Service;


@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }
    public void save(Balance balance){
        balanceRepository.save(balance);
    }

    public Iterable<Balance> getAlldata() {
        return balanceRepository.findAll();
    }
}

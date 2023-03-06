package csx.broker.Service;

import csx.broker.Entity.Buy;
import csx.broker.Repository.BuyRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyService {
    private final BuyRepository buyRepository;

    private BuyService(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;

    }

    public Iterable<Buy> getAll() {

        return buyRepository.findAll();
    }

    public Iterable<Buy> getAlldata() {
        return buyRepository.getAllData();
    }
}

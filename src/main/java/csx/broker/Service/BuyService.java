package csx.broker.Service;

import csx.broker.Entity.Buy;
import csx.broker.Repository.BuyRespository;
import org.springframework.stereotype.Service;

@Service
public class BuyService {
    private final BuyRespository buyRespository;
    private BuyService(BuyRespository buyRespository) {
        this.buyRespository = buyRespository;
    }
    public Iterable<Buy> getAll() {
        return buyRespository.findAll();
    }

    public Iterable<Buy> getAlldata() {
        return buyRespository.getAllData();
    }


    public void save(Buy buy){
        buyRespository.save(buy);
    }

    public void delete(int id){
        buyRespository.deleteById(id);
    }

}

package csx.broker.Service.bests;


//import csx.broker.Entity.accounts.Account;
import csx.broker.Entity.broker.Broker;
import csx.broker.Entity.bests.Best;
import csx.broker.Repository.bests.BestRepository;
import org.springframework.stereotype.Service;

@Service
public class BestService {
    private final BestRepository bestRepository;


    public BestService(BestRepository bestRepository) {
        this.bestRepository = bestRepository;
    }

    public Iterable<Best> getAlldata() {
        return bestRepository.getAllData();
    }

    public void save(Best best) {
        bestRepository.save(best);
    }

    //    public Iterable<Base> getAlldata() {
//        return accountRespository.getAllData();
//    }
    public void process(Broker req) {
        Best bestOrder = new Best();
//logic here


        bestOrder.setBestQty("500");
        bestOrder.setBestUV(500);
        bestOrder.setBestBroker("500");
        bestOrder.setBestType("3");

        save(bestOrder);
    }
//it to call two entity wwe should write in best service and broker order

}

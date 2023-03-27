package csx.broker.Service.broker;


import csx.broker.Entity.broker.Broker;
import csx.broker.Repository.broker.BrokerRepository;
import org.springframework.stereotype.Service;

@Service
public class BrokerService {
    private final BrokerRepository brokerRepository;

    private BrokerService(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }

    public Iterable<Broker> getAll() {
        return brokerRepository.findAll();
    }

//    public List<String> getAllBrokerId() {
//        return brokerRepository.getAllBrokerId();
//    }
    public void save(Broker broker){
        brokerRepository.save(broker);
    }

    public void delete(int OrderNo ){
        brokerRepository.deleteById(OrderNo);
    }


}

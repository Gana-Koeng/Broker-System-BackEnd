package csx.broker.Service;


import csx.broker.Entity.Broker;
import csx.broker.Repository.BrokerRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

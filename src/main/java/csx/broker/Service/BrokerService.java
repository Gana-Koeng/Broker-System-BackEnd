package csx.broker.Service;


import csx.broker.Entity.Broker;
import csx.broker.Repository.BrokerRepository;
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

    public Iterable<Broker> getAlldata() {
        return brokerRepository.getAllData();
    }

}

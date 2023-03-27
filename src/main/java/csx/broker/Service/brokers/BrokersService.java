package csx.broker.Service.brokers;


import csx.broker.Entity.brokers.Brokers;
import csx.broker.Repository.brokers.BrokersRepository;
import org.springframework.stereotype.Service;

@Service
public class BrokersService {
    private final BrokersRepository brokersRepository;

    private BrokersService(BrokersRepository brokersRepository) {
        this.brokersRepository = brokersRepository;
    }

//    public Iterable<Brokers> getAll() {
//        return brokersRepository.findAll();
//    }

//    public List<String> getAllBrokerId() {
//        return brokerRepository.getAllBrokerId();
//    }
    public void save(Brokers brokers){
        brokersRepository.save(brokers);
    }

    public void delete(int OrderNo ){
        brokersRepository.deleteById(OrderNo);
    }


    public Iterable<Brokers> getAlldata() {
        return brokersRepository.findAll();
    }
}

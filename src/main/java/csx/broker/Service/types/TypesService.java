package csx.broker.Service.types;


import csx.broker.Entity.types.Types;
import csx.broker.Repository.types.TypesRepository;
import org.springframework.stereotype.Service;

@Service
public class TypesService {
    private final TypesRepository typesRepository;

    private TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

//    public Iterable<Brokers> getAll() {
//        return brokersRepository.findAll();
//    }

//    public List<String> getAllBrokerId() {
//        return brokerRepository.getAllBrokerId();
//    }
    public void save(Types types){
        typesRepository.save(types);
    }

//    public void delete(int OrderNo ){
//        brokersRepository.deleteById(OrderNo);
//    }


    public Iterable<Types> getAlldata() {
        return typesRepository.findAll();
    }
}

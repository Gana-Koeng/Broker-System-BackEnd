package csx.broker.Service.execution;

import csx.broker.Entity.execution.execution;
import csx.broker.Repository.execution.executionRepository;
import org.springframework.stereotype.Service;

@Service
public class executionService {
    private final executionRepository executionRepository;
    private executionService(executionRepository executionRepository) {
        this.executionRepository = executionRepository;
    }
    public Iterable<execution> getAll() {
        return executionRepository.findAll();
    }

    public Iterable<execution> getAlldata() {
        return executionRepository.getAllData();
    }

    public void save(execution execution){
        executionRepository.save(execution);
    }

    public void delete(int id){
        executionRepository.deleteById(id);
    }

}

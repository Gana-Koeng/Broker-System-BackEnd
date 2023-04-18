package csx.broker.Service.execution;

import csx.broker.Entity.accounts.Account;
import csx.broker.Entity.execution.Execution;
import csx.broker.Repository.execution.ExecutionRepository;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {
    private final ExecutionRepository executionRepository;
    private ExecutionService(ExecutionRepository executionRepository) {
        this.executionRepository = executionRepository;
    }
    public Iterable<Execution> getAll() {
        return executionRepository.findAll();
    }

    public Iterable<Execution> getAlldata() {
        return executionRepository.getAllData();
    }


    public void save(Execution execution){
        executionRepository.save(execution);
    }



//    public void delete(String accountNo) {
//        accountRespository.delete(accountNo);
//    }
}

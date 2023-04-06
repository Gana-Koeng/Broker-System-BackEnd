package csx.broker.Service.recently;

import csx.broker.Entity.recently.recently;
import csx.broker.Repository.recently.recentlyRepository;
import org.springframework.stereotype.Service;

@Service
public class recentlyService {
    private final recentlyRepository recentlyRepository;
    private recentlyService(recentlyRepository recentlyRepository) {
        this.recentlyRepository = recentlyRepository;
    }
    public Iterable<recently> getAll() {
        return recentlyRepository.findAll();
    }

    public Iterable<recently> getAlldata() {
        return recentlyRepository.getAllData();
    }


    public void save(recently recently){
        recentlyRepository.save(recently);
    }

    public void delete(int id){
        recentlyRepository.deleteById(id);
    }

}

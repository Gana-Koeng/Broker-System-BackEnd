package csx.broker.Service.recently;

import csx.broker.Entity.recently.Recently;
import csx.broker.Repository.recently.RecentlyRepository;
import org.springframework.stereotype.Service;

@Service
public class RecentlyService {
    private final RecentlyRepository recentlyRepository;

    private RecentlyService(RecentlyRepository recentlyRepository) {
        this.recentlyRepository = recentlyRepository;
    }
    public void save(Recently recently){
        recentlyRepository.save(recently);
    }

    public Iterable<Recently> getAlldata() {
        return recentlyRepository.findAll();
    }
}

package csx.broker.Service;


import csx.broker.Entity.Recent;
import csx.broker.Repository.RecentRepository;
import org.springframework.stereotype.Service;

@Service
public class RecentService {
    private final RecentRepository recentRepository;

    private RecentService(RecentRepository recentRepository) {

        this.recentRepository = recentRepository;
    }

    public Iterable<Recent> getAll() {
        return recentRepository.findAll();
    }

    public Iterable<Recent> getAlldata() {
        return recentRepository.getAllData();
    }

}

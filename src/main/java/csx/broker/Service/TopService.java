package csx.broker.Service;

import csx.broker.Entity.Top;
import csx.broker.Repository.TopRespository;
import org.springframework.stereotype.Service;

@Service
public class TopService {
    private final TopRespository topRespository;
    private TopService(TopRespository topRespository) {
        this.topRespository = topRespository;
    }
    public Iterable<Top> getAll() {
        return topRespository.findAll();
    }

    public Iterable<Top> getAlldata() {
        return topRespository.getAllData();
    }
}

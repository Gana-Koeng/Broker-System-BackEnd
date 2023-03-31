package csx.broker.WebController.bests;

import csx.broker.BaseResponse;
import csx.broker.Entity.bests.Best;
import csx.broker.Repository.bests.BestRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getBaseInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BestRepository bestRepository;


    public getBaseInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BestRepository bestRepository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.bestRepository = bestRepository;
    }
    @GetMapping(value = {"api/best-info"})
    BaseResponse GetBaseInfo(){
        BaseResponse response = new BaseResponse();

        Iterable<Best>bests;

        bests = bestRepository.getAllData();
        response.setData(bests);
        return response;
    }
}

package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Recently;
import csx.broker.Repository.RecentlyRespository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRecentlyInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final RecentlyRespository recentlyRespository;

    public GetRecentlyInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, RecentlyRespository recentlyRespository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.recentlyRespository = recentlyRespository;
    }

    @GetMapping(value = {"api/recentlies-info"})
    BaseResponse GetBuyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Recently> recentlies;

        recentlies = recentlyRespository.getAllData();
        response.setData(recentlies);
//        response.setResCode(1);
        response.setResMsg("show Data successful...");
        return response;

    }

}

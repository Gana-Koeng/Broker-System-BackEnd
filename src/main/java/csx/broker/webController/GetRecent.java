package csx.broker.webController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Recent;
import csx.broker.Service.RecentService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRecent {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final RecentService recentService;

    public GetRecent(NamedParameterJdbcTemplate namedParameterJdbcTemplate, RecentService recentService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.recentService = recentService;
    }

    @GetMapping(value = {"api/recent-info"})
    BaseResponse GetRecentInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Recent> recentList;

        recentList = recentService.getAlldata();
        response.setData(recentList);
        return response;

    }
}
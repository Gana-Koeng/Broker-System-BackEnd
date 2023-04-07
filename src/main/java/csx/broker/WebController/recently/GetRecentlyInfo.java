package csx.broker.WebController.recently;

import csx.broker.BaseResponse;
import csx.broker.Entity.recently.Recently;
import csx.broker.Service.recently.RecentlyService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRecentlyInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final RecentlyService recentlyService;

    public GetRecentlyInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, RecentlyService recentlyService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.recentlyService = recentlyService;
    }

    @GetMapping(value = {"api/recently-info"})
    BaseResponse GetRecentlyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Recently> recently;

        recently = recentlyService.getAlldata();
        response.setData(recently);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }

}

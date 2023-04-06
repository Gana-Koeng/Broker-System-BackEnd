package csx.broker.WebController.recently;

import csx.broker.BaseResponse;
import csx.broker.Entity.recently.recently;
import csx.broker.Service.recently.recentlyService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class recentlyInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final recentlyService recentlyService;

    public recentlyInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, recentlyService recentlyService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.recentlyService = recentlyService;
    }

    @GetMapping(value = {"api/recently-info"})
    BaseResponse recentlyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<recently> recently;

        recently = recentlyService.getAlldata();
        response.setData(recently);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }
}

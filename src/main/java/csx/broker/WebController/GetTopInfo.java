package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Top;
import csx.broker.Service.TopService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTopInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final TopService topService;

    public GetTopInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, TopService topService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.topService = topService;
    }

    @GetMapping(value = {"api/top-info"})
    BaseResponse GetTopInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Top> topList;

        topList = topService.getAlldata();
        response.setData(topList);
        response.setResCode(1);
        response.setResMsg(1);
        return response;

    }
}

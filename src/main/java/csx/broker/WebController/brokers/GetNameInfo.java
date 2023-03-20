package csx.broker.WebController.brokers;

import csx.broker.BaseResponse;
import csx.broker.Entity.Brokers;
import csx.broker.Service.BrokersService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetNameInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BrokersService brokersService;

    public GetNameInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BrokersService brokersService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.brokersService = brokersService;
    }

    @GetMapping(value = {"api/brokers-account-info"})
    BaseResponse GetNameInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Brokers> brokers;

        brokers = brokersService.getAlldata();
        response.setData(brokers);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }

}

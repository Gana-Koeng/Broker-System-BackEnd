package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Broker;
import csx.broker.Service.BrokerService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetBrokerInfo {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BrokerService brokerService;

    public GetBrokerInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BrokerService brokerService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.brokerService = brokerService;
    }

    @GetMapping(value = {"api/broker-info"})
    BaseResponse GetBrokerInfo() {
        BaseResponse response = new BaseResponse();
//        List<String> brokerList;
        Iterable<Broker> brokerList;

//        brokerList = brokerService.getAllBrokerId();
        brokerList = brokerService.getAll();
        response.setData(brokerList);
        return response;

    }
}
package csx.broker.WebController.Balance;

import csx.broker.BaseResponse;
import csx.broker.Entity.Balance;
import csx.broker.Service.BalanceService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetBalance {



    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BalanceService balanceService;

    public GetBalance(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BalanceService balanceService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.balanceService = balanceService;
    }

    @PostMapping("/api/balance-order")
    BaseResponse buyOrder(@RequestBody Balance req){
        BaseResponse response = new BaseResponse();



        balanceService.save(req);
        response.setResMsg("Successfully");

        return response;
    }
}

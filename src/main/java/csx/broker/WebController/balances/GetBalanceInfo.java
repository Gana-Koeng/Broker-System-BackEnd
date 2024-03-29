package csx.broker.WebController.balances;

import csx.broker.BaseResponse;
import csx.broker.Entity.balances.Balance;
import csx.broker.Repository.balances.BalanceRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBalanceInfo {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BalanceRepository balanceRepository;

    public GetBalanceInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BalanceRepository balanceRepository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.balanceRepository = balanceRepository;
    }

    @GetMapping(value = {"api/balance-info"})
    BaseResponse GetBaseInfo(){
        BaseResponse response = new BaseResponse();
        Iterable<Balance>balances;

        balances = balanceRepository.getAllData();
        response.setData(balances);
        return response;
    }
}

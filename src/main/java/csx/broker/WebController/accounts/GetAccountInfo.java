package csx.broker.WebController.accounts;

import csx.broker.BaseResponse;
import csx.broker.Entity.Account;
import csx.broker.Service.AccountService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final AccountService accountService;

    public GetAccountInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, AccountService accountService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.accountService = accountService;
    }

    @GetMapping(value = {"api/account-info"})
    BaseResponse GetBuyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Account> accounts;

        accounts = accountService.getAlldata();
        response.setData(accounts);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }

}

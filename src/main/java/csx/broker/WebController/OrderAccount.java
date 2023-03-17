package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Account;
import csx.broker.Service.AccountService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAccount {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final AccountService accountService;

    public OrderAccount(NamedParameterJdbcTemplate namedParameterJdbcTemplate, AccountService accountService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.accountService = accountService;
    }

    @PostMapping("/api/account-order")
    BaseResponse BuyOrder(@RequestBody Account req){
        BaseResponse response = new BaseResponse();


//        System.out.println("odrId  : " + req.getId());
//        System.out.println("price  : " + req.getPrice());
//        System.out.println("buy    : " + req.getBuy());


//        String sql = "                              \n"+
//                "INSERT INTO buy (id, buy, price)   \n" +
//                "VALUES (:id, :qty, :prc);          ";
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", req.getId());
//        params.addValue("qty", req.getBuy());
//        params.addValue("prc", req.getPrice());
//
//        namedParameterJdbcTemplate.update(
//                sql,
//                params
//        );

        accountService.save(req);
//        System.out.println("odrId  : " + req.getId());
//        System.out.println("price  : " + req.getPrice());
//        System.out.println("buy    : " + req.getBuy());

//        accountService.delete(req.getAccountNo());

        return response;
    }
}

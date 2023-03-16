package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Buy;
import csx.broker.Service.BuyService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderBuy {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BuyService buyService;

    public OrderBuy(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BuyService buyService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.buyService = buyService;
    }

    @PostMapping("/api/buy-order")
    BaseResponse BuyOrder(@RequestBody Buy req){
        BaseResponse response = new BaseResponse();
        System.out.println("odrId  : " + req.getId());
        System.out.println("price  : " + req.getPrice());
        System.out.println("buy    : " + req.getBuy());


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

//        buyService.save(req);
//        System.out.println("odrId  : " + req.getId());
//        System.out.println("price  : " + req.getPrice());
//        System.out.println("buy    : " + req.getBuy());

        buyService.delete(req.getId());

        return response;
    }
}

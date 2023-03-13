package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Buy;
import csx.broker.Service.BuyService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBuyInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BuyService buyService;

    public GetBuyInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BuyService buyService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.buyService = buyService;
    }

    @GetMapping(value = {"api/buy-info"})
    BaseResponse GetBuyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Buy> buyList;

        buyList = buyService.getAlldata();
        response.setData(buyList);
        response.setResCode(1);
        response.setResMsg(1);
        return response;

    }
}

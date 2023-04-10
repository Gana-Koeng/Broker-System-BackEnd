package csx.broker.WebController.broker;

import csx.broker.BaseResponse;
import csx.broker.Entity.broker.Broker;
//import csx.broker.Repository.bests.BestRepository;
import csx.broker.Service.broker.BrokerService;
import csx.broker.Service.bests.BestService;
import csx.broker.websocket.etc.RawSocketHandler;
import csx.broker.websocket.send.QuotationDataSending;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderBroker {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BrokerService brokerService;
    final BestService bestService;
    final QuotationDataSending quotationDataSending;
    final RawSocketHandler rawSocketHandler;

    public OrderBroker(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BrokerService brokerService, BestService bestService, QuotationDataSending quotationDataSending, RawSocketHandler rawSocketHandler) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.brokerService = brokerService;
        this.bestService = bestService;

        this.quotationDataSending = quotationDataSending;
        this.rawSocketHandler = rawSocketHandler;
    }

    @PostMapping("/api/broker-order")
    BaseResponse BuyOrder(@RequestBody Broker req) {
        BaseResponse response = new BaseResponse();

//        System.out.println("Successful---->");
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

        brokerService.save(req);

//        bestService.process(req);
        quotationDataSending.sending(rawSocketHandler, req);

//        bestService.getExistingBestOrder(in);
/*
        bestService.getExistingBestOrder();
        System.out.println("odrId  : " + req.getId());
        System.out.println("price  : " + req.getPrice());
        System.out.println("buy    : " + req.getBuy());
       brokerService.delete(req.getOrderNo());
*/

        response.setResMsg("Order Successfully...");
        response.setResCode(1);

        return response;

    }
}

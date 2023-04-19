package csx.broker.WebController.execution;

import csx.broker.BaseResponse;
import csx.broker.Entity.execution.Execution;
import csx.broker.Service.bests.BestService;
import csx.broker.Service.execution.ExecutionService;
import csx.broker.websocket.etc.RawSocketHandler;
import csx.broker.websocket.send.QuotationDataSending;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderExecution {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final ExecutionService executionService;
    final BestService bestService;
    final QuotationDataSending quotationDataSending;
    final RawSocketHandler rawSocketHandler;

    public OrderExecution(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ExecutionService executionService, BestService bestService, QuotationDataSending quotationDataSending, RawSocketHandler rawSocketHandler) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.executionService = executionService;
        this.bestService = bestService;
        this.quotationDataSending = quotationDataSending;
        this.rawSocketHandler = rawSocketHandler;
    }
//    final BestService bestService;
//    final QuotationDataSending quotationDataSending;
//    final RawSocketHandler rawSocketHandler;



    @PostMapping("/api/execution-order")
    BaseResponse BuyOrder(@RequestBody Execution req) {
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

        executionService.save(req);

//        bestService.process(req);
//        quotationDataSending.sending(rawSocketHandler, req);

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

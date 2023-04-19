package csx.broker.WebController.broker;

import csx.broker.BaseResponse;
import csx.broker.Entity.broker.Broker;
//import csx.broker.Repository.bests.BestRepository;
import csx.broker.Service.TcpService.TcpService;
import csx.broker.Service.broker.BrokerService;
import csx.broker.Service.bests.BestService;
import csx.broker.websocket.etc.RawSocketHandler;
import csx.broker.websocket.send.QuotationDataSending;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
public class OrderBroker {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BrokerService brokerService;
    final BestService bestService;
    final QuotationDataSending quotationDataSending;
    final RawSocketHandler rawSocketHandler;

    final TcpService tcpService;

    private static final String TCP_IP = "10.10.18.220";
    private static final int TCP_PORT = 5000;



    public OrderBroker(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BrokerService brokerService, BestService bestService, QuotationDataSending quotationDataSending, RawSocketHandler rawSocketHandler, TcpService tcpService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.brokerService = brokerService;
        this.bestService = bestService;

        this.quotationDataSending = quotationDataSending;
        this.rawSocketHandler = rawSocketHandler;
        this.tcpService = tcpService;
    }

    @PostMapping("/api/broker-order")
    BaseResponse BuyOrder(@RequestBody Broker req) {
        BaseResponse response = new BaseResponse();

        //order validation
        brokerService.save(req);


        String deserielizeObject = deserielization(req);
        try{
            tcpService.startConnection(TCP_IP, TCP_PORT);

            tcpService.sendMessage(deserielizeObject);

        }catch (Exception e){
            System.out.println("Tcp cannot connect to client");
            tcpService.stopConnection();
        }




//        quotationDataSending.sending(rawSocketHandler, req);

        response.setResMsg("Order Successfully. . .");
        response.setResCode(1);

        return response;

    }


    private String deserielization(Broker in){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(in.getOrderDate());

        return String.valueOf(in.getOrderUV())+String.valueOf(in.getOrderQty()) +formattedDate ;

    }
}

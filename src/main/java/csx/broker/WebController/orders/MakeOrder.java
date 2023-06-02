package csx.broker.WebController.orders;

import csx.broker.BaseResponse;
import csx.broker.Entity.orders.Order;
import csx.broker.Service.TcpService.TcpService;
import csx.broker.Service.bests.BestService;
import csx.broker.Service.orders.OrderService;
import csx.broker.websocket.etc.RawSocketHandler;
import csx.broker.websocket.send.QuotationDataSending;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

import static java.lang.String.format;

@RestController
public class MakeOrder {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final OrderService orderService;
    final BestService bestService;
    final QuotationDataSending quotationDataSending;
    final RawSocketHandler rawSocketHandler;
    final TcpService tcpService;
    private static final String TCP_IP = "192.168.105.120";
    private static final int TCP_PORT = 5000;



    public MakeOrder(NamedParameterJdbcTemplate namedParameterJdbcTemplate, OrderService orderService, BestService bestService, QuotationDataSending quotationDataSending, RawSocketHandler rawSocketHandler, TcpService tcpService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.orderService = orderService;
        this.bestService = bestService;

        this.quotationDataSending = quotationDataSending;
        this.rawSocketHandler = rawSocketHandler;
        this.tcpService = tcpService;
    }

    @PostMapping("/api/broker-order")
    BaseResponse BuyOrder(@RequestBody Order req) {
        BaseResponse response = new BaseResponse();

        //order validation
        orderService.save(req);


        String deserielizeObject = deserielization(req);
        try{
            tcpService.startConnection(TCP_IP, TCP_PORT);

            tcpService.sendMessage(deserielizeObject);

        }catch (Exception e){
            System.out.println("Tcp cannot connect to client");
            tcpService.stopConnection();
        }

        quotationDataSending.sending(rawSocketHandler, req);

        response.setResMsg("Order Successfully. . .");
        response.setResCode(1);
        return response;
    }
    private String deserielization(Order in){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(in.getOrderDate());
        if (in.getOrderType()== 1){
           String msgMessage = "S1"                                                  +
                               in.getIssueCode()                                     +
                               in.getOrderType()                                     +
                               in.getBrokerId()                                      +
                               in.getAccountNo()                                     +
                               format("%010d",in.getOriginalOrderNo())               +
                               format("%010d", in.getOrderQty())                     +
                               format("%010d", in.getOrderUV())                      + formattedDate ;
            return msgMessage;
         }
        if (in.getOrderType()== 2){
            String msgMessage = "B1"                                                  +
                                in.getIssueCode()                                     +
                                in.getOrderType()                                     +
                                in.getBrokerId()                                      +
                                in.getAccountNo()                                     +
                                format("%010d",in.getOriginalOrderNo())               +
                                format("%010d", in.getOrderQty())                     +
                                format("%010d", in.getOrderUV())                      + formattedDate ;
            return msgMessage;
         }

        return null;
    }
}

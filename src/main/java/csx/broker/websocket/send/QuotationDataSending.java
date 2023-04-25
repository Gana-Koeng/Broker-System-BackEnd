package csx.broker.websocket.send;

import csx.broker.Entity.orders.Order;
import csx.broker.websocket.etc.RawSocketHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import static java.lang.String.*;

@Service
@Log4j2
public class QuotationDataSending {

    public void sending(RawSocketHandler rawSocketHandler, Order Order) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(Order.getOrderDate());

        if (Order.getOrderType() == 1) {
            String msgSend =    "A1"                                                     +
                                Order.getIssueCode()                                     +
                                format("%04d",Integer.parseInt(Order.getBrokerId()))     +
                                format("%04d",Integer.parseInt(Order.getAccountNo()))    +
                                format("%08d",Order.getOriginalOrderNo())                +
                                format("%08d", Order.getOrderUV())                       +
                                format("%08d", Order.getOrderUV())                       + formattedDate;
            log.info("Send growth board market data [{}]", msgSend); //console.log in intellij
            rawSocketHandler.sendAll(msgSend);
        }
        if (Order.getOrderType() == 2) {
            String msgSend =    "A2"                                                     +
                                Order.getIssueCode()                                     +
                                format("%04d",Integer.parseInt(Order.getBrokerId()))     +
                                format("%04d",Integer.parseInt(Order.getAccountNo()))    +
                                format("%08d",Order.getOriginalOrderNo())                +
                                format("%08d", Order.getOrderUV())                       +
                                format("%08d", Order.getOrderUV())                       + formattedDate;
            log.info("Send growth board market data [{}]", msgSend); //console.log in intellij
            rawSocketHandler.sendAll(msgSend);
        }
    }
}

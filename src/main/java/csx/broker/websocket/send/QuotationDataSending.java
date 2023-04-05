package csx.broker.websocket.send;

import csx.broker.Entity.broker.Broker;
import csx.broker.websocket.etc.RawSocketHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@Log4j2
public class QuotationDataSending {

    public void sending(RawSocketHandler rawSocketHandler, Broker broker) {


//        String msgSend = broker.getBrokerId() + broker.getIssueCode() + broker.getOrderDate().SimpleDateFormat("yyyyMMdd");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(broker.getOrderDate());


        String msgSend =    broker.getIssueCode()                       +
                            String.format("%06d", broker.getOrderQty()) +
                            String.format("%05d", broker.getOrderUV())  +
                            String.format("%06d", broker.getOrderNo())  + formattedDate;


        log.info("Send growth board market data [{}]", msgSend); //console.log in intellij
        rawSocketHandler.sendAll(msgSend);
    }
}

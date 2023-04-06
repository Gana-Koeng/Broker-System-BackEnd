package csx.broker.websocket.send;

import csx.broker.Entity.broker.Broker;
import csx.broker.websocket.etc.RawSocketHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import static java.lang.String.*;

@Service
@Log4j2
public class QuotationDataSending {

    public void sending(RawSocketHandler rawSocketHandler, Broker broker) {


//        String msgSend = broker.getBrokerId() + broker.getIssueCode() + broker.getOrderDate().SimpleDateFormat("yyyyMMdd");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(broker.getOrderDate());

        if (broker.getOrderType() == 1) {
            String msgSend =    "A1"                                            +
                                format("%09d",broker.getIssueCode())           +
//                                format("%04d",broker.getBrokerId())             +
//                                format("%05d",broker.getAccountNo())            +
                                format("%08d",broker.getOriginalOrderNo())      +
                                format("%08d", broker.getOrderUV())             +
                                format("%08d", broker.getOrderUV())             + formattedDate;

            log.info("Send growth board market data [{}]", msgSend); //console.log in intellij
            rawSocketHandler.sendAll(msgSend);
        }
        if (broker.getOrderType() == 2) {
            String msgSend =    "A2"                                            +
                                format("%09d",broker.getIssueCode())           +
                                format("%A8s",broker.getBrokerId())             +
                                format("%s",broker.getAccountNo())            +
                                format("%08d",broker.getOriginalOrderNo())      +
                                format("%08d", broker.getOrderUV())             +
                                format("%08d", broker.getOrderUV())             + formattedDate;

            log.info("Send growth board market data [{}]", msgSend); //console.log in intellij
            rawSocketHandler.sendAll(msgSend);
        }





    }
}

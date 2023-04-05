package csx.broker.websocket.send;

import  csx.broker.Entity.QuotationData;
import csx.broker.websocket.etc.RawSocketHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class QuotationDataSending {

    public void sending(RawSocketHandler rawSocketHandler, QuotationData quotationData) {

        log.info("Send growth board market data [{}]", quotationData.getData());
        rawSocketHandler.sendAll(quotationData.getData());
    }
}

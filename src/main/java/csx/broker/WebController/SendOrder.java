package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendOrder {


    @PostMapping(value = {"api/send-order"})
    BaseResponse sendOrder(@RequestBody Order req){
        BaseResponse response = new BaseResponse();

//        req.newSell = req.sell-req.qty;

        System.out.println("odrId  : " + req.odrId);
        System.out.println("accNo  : " + req.accNo);
        System.out.println("qty    : " + req.qty);
        System.out.println("prc    : " + req.prc);
        System.out.println("New price    : " + req.newSell);



        response.setResCode(1);
        response.setResMsg(1);
        response.setData(req);
        return response;
    }
}

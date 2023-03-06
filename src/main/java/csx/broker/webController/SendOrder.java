package csx.broker.webController;

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

        System.out.println("odrId  : " + req.odrId);
        System.out.println("accNo  : " + req.accNo);
        System.out.println("qty    : " + req.qty);
        System.out.println("prc    : " + req.prc);

        response.setResCode("100");
        response.setData(req);
        return response;
    }
}

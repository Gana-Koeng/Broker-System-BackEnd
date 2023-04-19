package csx.broker;

import csx.broker.Entity.broker.Broker;
import csx.broker.Repository.broker.BrokerRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestHashMap {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BrokerRepository brokerRepository;

    public TestHashMap(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BrokerRepository brokerRepository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.brokerRepository = brokerRepository;
    }

    @GetMapping(value = {"api/v1/test/hashmap"})
    BaseResponse TestHashMap( Broker broker) {
        BaseResponse response = new BaseResponse();

        HashMap<String,List<Order>> hm= new HashMap<>();


//        int i =  0;
        List<Order> orderList = new ArrayList<>();
//
//        while(i < 3){
        Order order = new Order();
            order.issueCode = String.valueOf(broker.getIssueCode());
            order.orderType = String.valueOf(broker.getOrderType());
            order.orderPrice = 5000;
            order.accNo = "00100";
            order.orderQty = broker.getOrderQty();

        String key = order.issueCode+order.orderPrice+order.orderType;

        if(hm.get(key) == null){
                orderList.add(order);
            }else {
                orderList = hm.get(key);
                orderList.add(order);
            }

            hm.put(key, orderList);


//            i++;

//        System.out.println("HERE : " + hm.get("125000").get(0).orderType);

        System.out.println("Initial list of elements: "+hm);

        return response;
    }


    class Order{
        String issueCode;
        String accNo;
        String orderType;
        int orderPrice;
        int orderQty;
    }


}

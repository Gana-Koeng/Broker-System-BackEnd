package csx.broker.WebController.contacts;

import csx.broker.BaseResponse;
import csx.broker.Entity.Contacts;
import csx.broker.Service.ContactService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderContact {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final ContactService contactService;

    public OrderContact(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ContactService contactService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.contactService = contactService;
    }

    @PostMapping("/api/contact-order")
    BaseResponse buyOrder(@RequestBody Contacts req){
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

        contactService.save(req);
//        System.out.println("odrId  : " + req.getId());
//        System.out.println("price  : " + req.getPrice());
//        System.out.println("buy    : " + req.getBuy());

//       brokerService.delete(req.getOrderNo());


        return response;
    }
}

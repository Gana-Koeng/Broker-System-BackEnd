package csx.broker.WebController.contacts;

import csx.broker.BaseResponse;
import csx.broker.Entity.Contacts;
import csx.broker.Service.ContactService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetContactInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final ContactService contactService;

    public GetContactInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ContactService contactService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.contactService = contactService;
    }

    @GetMapping(value = {"api/contact-info"})
    BaseResponse GetContactInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Contacts> contacts;

        contacts = contactService.getAlldata();
        response.setData(contacts);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }

}

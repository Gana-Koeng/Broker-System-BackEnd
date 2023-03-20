package csx.broker.WebController.types;

import csx.broker.BaseResponse;
import csx.broker.Entity.Types;
import csx.broker.Service.TypesService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTypesInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final TypesService typesService;

    public GetTypesInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, TypesService typesService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.typesService = typesService;
    }

    @GetMapping(value = {"api/types-info"})
    BaseResponse GetTypesInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Types> types;

        types = typesService.getAlldata();
        response.setData(types);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }

}

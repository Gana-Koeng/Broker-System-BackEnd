package csx.broker.WebController.execution;

import csx.broker.BaseResponse;
import csx.broker.Entity.execution.execution;
import csx.broker.Entity.issues.Issue;
import csx.broker.Service.execution.executionService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class executionInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final executionService executionService;

    public executionInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, executionService executionService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.executionService = executionService;
    }
    @GetMapping(value = {"api/execution-info"})
    BaseResponse executionInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<execution> execution;

        execution = executionService.getAlldata();
        response.setData(execution);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }
}

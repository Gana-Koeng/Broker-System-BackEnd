package csx.broker.WebController.execution;

import csx.broker.BaseResponse;

import csx.broker.Entity.execution.Execution;
import csx.broker.Repository.execution.ExecutionRepository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetExecutionInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final ExecutionRepository executionRepository;

    public GetExecutionInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ExecutionRepository executionRepository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.executionRepository = executionRepository;
    }

    @GetMapping(value = {"api/execution-info"})
    BaseResponse GetBuyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Execution> executions;

        executions = executionRepository.getAllData();
        response.setData(executions);
//        response.setResCode(1);
        response.setResMsg("show Data successful...");
        return response;

    }

}

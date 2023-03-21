package csx.broker.WebController.Stock;

import csx.broker.BaseResponse;
import csx.broker.Entity.Issue;
import csx.broker.Service.IssueService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetIssueInfo {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final IssueService issueService;

    public GetIssueInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, IssueService issueService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.issueService = issueService;
    }

    @GetMapping(value = {"api/issue-info"})
    BaseResponse GetBuyInfo() {
        BaseResponse response = new BaseResponse();
        Iterable<Issue> issues;

        issues = issueService.getAlldata();
        response.setData(issues);
//        response.setResCode(1);
//        response.setResMsg(1);
        return response;

    }
}

package csx.broker.WebController.broker;

import csx.broker.BaseResponse;
import csx.broker.Service.issues.IssueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeleteStockInfo {

    final IssueService issueService;

    public DeleteStockInfo(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping(value = "api/delete-stock")
    public BaseResponse deleteStock(@RequestBody int issueCode) {
        BaseResponse res = new BaseResponse();

        try {
            issueService.delete(issueCode);
            res.setResMsg("delete successful");
        } catch (Exception e) {
            System.out.println(e);
            res.setResMsg("delete fail");
        }

        return res;
    }
}

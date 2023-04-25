package csx.broker.WebController.issues;

import csx.broker.BaseResponse;
import csx.broker.Service.issues.IssueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeleteIssueInfo {

    final IssueService issueService;

    public DeleteIssueInfo(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping(value = {"api/delete-stock"})
    BaseResponse deleteStock(@RequestParam int id){
        BaseResponse res = new BaseResponse();


        try{
            issueService.delete(id);

            res.setResMsg("delete successful");
        }catch (Exception e){
            System.out.println(e);
            res.setResMsg("delete fail");
        }

        return res;


    }
}

package csx.broker.WebController.Stock;

import csx.broker.BaseResponse;
import csx.broker.Service.IssueService;
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

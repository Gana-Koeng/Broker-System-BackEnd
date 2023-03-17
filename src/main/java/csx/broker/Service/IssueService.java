package csx.broker.Service;

import csx.broker.Entity.Issue;
import csx.broker.Repository.IssueRespository;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    private final IssueRespository issueRespository;
    private IssueService(IssueRespository issueRespository) {
        this.issueRespository = issueRespository;
    }
    public Iterable<Issue> getAll() {
        return issueRespository.findAll();
    }

    public Iterable<Issue> getAlldata() {
        return issueRespository.getAllData();
    }


    public void save(Issue issue){
        issueRespository.save(issue);
    }

    public void delete(int id){
        issueRespository.deleteById(id);
    }

}

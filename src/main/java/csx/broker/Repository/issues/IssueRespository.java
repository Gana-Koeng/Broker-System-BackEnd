package csx.broker.Repository.issues;


import csx.broker.Entity.issues.Issue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRespository extends CrudRepository<Issue,Integer> {

    @Query(value = "SELECT * FROM stock ", nativeQuery = true)
    Iterable<Issue> getAllData();


}
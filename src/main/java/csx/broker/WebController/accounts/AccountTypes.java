package csx.broker.WebController.accounts;

import csx.broker.BaseResponse;
import csx.broker.Service.accounts.AccountService;
import lombok.Builder;
import lombok.Data;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountTypes {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final AccountService accountService;

    public AccountTypes(NamedParameterJdbcTemplate namedParameterJdbcTemplate, AccountService accountService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.accountService = accountService;
    }


    @GetMapping(value = {"api/accountTypes-info"})
    BaseResponse AccountTypes() {
        BaseResponse response = new BaseResponse();

//        String startDate = "2023-03-15";
//        String endDate = "2023-03-21";
//        List<String> brokerList;
//        Iterable<Broker> brokerList;

//        brokerList = brokerService.getAllBrokerId();
//        brokerList = brokerService.getAll();
//        response.setData(brokerList);

        String sql = "" +
                "SELECT A.account_no                          AC_NO     \n" +
                "     , A.account_name                        AC_NM     \n" +
                "     , A.type                                AC_TY     \n" +
                "     , B.name                                ACC_NM     \n" +
                "  FROM accounts A                                      \n" +
                "     , accounts_types B                                \n" +
                " WHERE A.type = B.type                     \n" ;

//                "   AND A.order_date BETWEEN :fromDate \n" +
//                "                        AND :toDate     ";
        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("fromDate", startDate);
//        params.addValue("toDate", endDate);

        List<accountTypes> AccountType = namedParameterJdbcTemplate.query(
                sql,
                params,
                (resultSet, i) -> {
                    return accountTypes.builder()
                            .accountNo(resultSet.getString("AC_NO"))
                            .accountName(resultSet.getString("AC_NM"))
                            .accountType(resultSet.getString("AC_TY"))
                            .name(resultSet.getString("ACC_NM"))


                            .build();
                }
        );

        response.setData(AccountType);
        return response;

    }

    @Data
    @Builder
    static class accountTypes {
        String accountNo;
        String accountName;

        String accountType;
        String name;

    }
}
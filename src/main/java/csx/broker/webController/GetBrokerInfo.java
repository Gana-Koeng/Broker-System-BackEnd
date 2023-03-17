package csx.broker.WebController;

import csx.broker.BaseResponse;
import csx.broker.Entity.Broker;
import csx.broker.Service.BrokerService;
import lombok.Builder;
import lombok.Data;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;

@RestController
public class GetBrokerInfo {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final BrokerService brokerService;

    public GetBrokerInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BrokerService brokerService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.brokerService = brokerService;
    }

    @GetMapping(value = {"api/broker-info"})
    BaseResponse GetBrokerInfo() {
        BaseResponse response = new BaseResponse();

        String startDate = "2023-03-15";
        String endDate = "2023-03-21";
//        List<String> brokerList;
//        Iterable<Broker> brokerList;

//        brokerList = brokerService.getAllBrokerId();
//        brokerList = brokerService.getAll();
//        response.setData(brokerList);

        String sql = "" +
                "SELECT A.order_no          ORD_NO     \n" +
                "     , A.order_date        ORD_DT     \n" +
                "     , B.issue_name        ISU_NM     \n" +
                "  FROM table_order A                  \n" +
                "     , stock B                        \n" +
                " WHERE A.issue_code = B.issue_code    \n" +
                "   AND A.order_date BETWEEN :fromDate \n" +
                "                        AND :toDate     ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("fromDate", startDate);
        params.addValue("toDate", endDate);

        List<IssueOrder> issueOdr = namedParameterJdbcTemplate.query(
                sql,
                params,
                (resultSet, i) -> {
                    return IssueOrder.builder()
                            .orderNo(resultSet.getString("ORD_NO"))
                            .orderDt(resultSet.getString("ORD_DT"))
                            .orderNm(resultSet.getString("ISU_NM"))
                            .build();
                }
        );

        response.setData(issueOdr);
        return response;

    }

    @Data
    @Builder
    static class IssueOrder {
        String orderNo;
        String orderDt;
        String orderNm;
    }
}
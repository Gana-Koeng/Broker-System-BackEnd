package csx.broker.WebController.brokers;

import csx.broker.BaseResponse;

import csx.broker.Service.orders.OrderService;
import lombok.Builder;
import lombok.Data;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetBrokersInfo {

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final OrderService orderService;

    public GetBrokersInfo(NamedParameterJdbcTemplate namedParameterJdbcTemplate, OrderService orderService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.orderService = orderService;

    }

    @GetMapping(value = {"api/brokers-info"})
    BaseResponse GetBrokerInfo() {
        BaseResponse response = new BaseResponse();

//        String startDate = "2023-03-15";
//        String endDate = "2023-03-21";
//        List<String> brokerList;
//        Iterable<Broker> brokerList;

//        brokerList = brokerService.getAllBrokerId();
//        brokerList = brokerService.getAll();
//        response.setData(brokerList);

        String sql = "" +
                "SELECT A.order_no                          OD_NO     \n" +
                "     , A.order_date                        OD_DT     \n" +
                "     , A.broker_id                         BK_ID     \n" +
                "     , A.order_type                        OD_TY     \n" +
                "     , A.account_no                        AC_NO     \n" +
                "     , A.original_order_no                 ON_NO     \n" +
                "     , A.order_qty                         OD_QY     \n" +
                "     , A.order_uv                          OD_UV     \n" +
                "     , B.broker_name                       BK_NM     \n" +
                "     , A.issue_code                        ISU_CD    \n" +
                "  FROM table_order A                                 \n" +
                "     , brokers B                                     \n" +
                " WHERE A.broker_id = B.broker_id                     \n" ;

//                "   AND A.order_date BETWEEN :fromDate \n" +
//                "                        AND :toDate     ";
        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("fromDate", startDate);
//        params.addValue("toDate", endDate);

        List<IssueOrder> issueOdr = namedParameterJdbcTemplate.query(
                sql,
                params,
                (resultSet, i) -> {
                    return IssueOrder.builder()
                            .orderNo(resultSet.getString("OD_NO"))
                            .orderDt(resultSet.getString("OD_DT"))
                            .brokerId(resultSet.getString("BK_ID"))
                            .orderType(resultSet.getString("OD_TY"))
                            .accountNo(resultSet.getString("AC_NO"))
                            .originalOrderNo(resultSet.getString("ON_NO"))
                            .orderQty(resultSet.getString("OD_QY"))
                            .orderUV(resultSet.getString("OD_UV"))
                            .brokerName(resultSet.getString("BK_NM"))
                            .issueCode(resultSet.getString("ISU_CD"))

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

        String brokerId;
        String orderType;
        String issueCode;
        String accountNo;
        String originalOrderNo;
        String orderQty;
        String orderUV;
        String brokerName;


    }
}
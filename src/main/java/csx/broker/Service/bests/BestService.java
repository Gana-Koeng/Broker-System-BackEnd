package csx.broker.Service.bests;



import csx.broker.Entity.bests.Best;

import csx.broker.Entity.orders.Order;
import csx.broker.Repository.bests.BestRepository;

import csx.broker.Repository.orders.OrderRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BestService {
    private final BestRepository bestRepository;
    private final OrderRepository orderRepository;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BestService(BestRepository bestRepository, OrderRepository orderRepository) {
        this.bestRepository = bestRepository;

        this.orderRepository = orderRepository;
    }

    public Iterable<Best> getAlldata() {
        return bestRepository.getAllData();
    }

    public void save(Best best) {
        bestRepository.save(best);
    }

    //    public Iterable<Base> getAlldata() {
//        return accountRespository.getAllData();
//    }
    public void process(Order req) {
        Best bestOrder = new Best();
        
        bestOrder.setOrderQty(req.getOrderQty());
        bestOrder.setOrderUv(Integer.parseInt(String.valueOf(req.getOrderUV())));
        bestOrder.setOrderStock(String.valueOf(req.getIssueCode()));
        bestOrder.setOrderType(String.valueOf(req.getOrderType()));

        save(bestOrder);
    }
//it to call two entity we should write in best service and broker order

    public void getExistingBestOrder(Best in) {

        String GET_BEST_PRICE = "" +
                "  SELECT COUNT(*)                     \n" +
                "  FROM best_price                     \n" +
                "  WHERE order_type = :orderType        \n" +
                "    AND order_uv = :orderUV            \n" +
                "    AND order_qty = :orderQty          \n" +
                "    AND order_stock = :orderStock      \n" +
                " ;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderType", in.getOrderType());
        params.addValue("orderUV", in.getOrderUv());
        params.addValue("orderQty", in.getOrderQty());
        params.addValue("orderStock", in.getOrderStock());

        int exist = namedParameterJdbcTemplate.queryForObject(
                GET_BEST_PRICE,
                params,
                int.class
        );

        if (exist == 0) {

            String INSERT_BEST_PRICE = "" +
                    "INSERT INTO best_price           \n" +
                    "          ( order_type            \n" +
                    "          , order_uv              \n" +
                    "          , order_qty             \n" +
                    "          , order_stock)          \n" +
                    "   VALUES (:orderType            \n" +
                    "         , :orderUV              \n" +
                    "         , :orderQty             \n" +
                    "         , :orderStock);           ";


            namedParameterJdbcTemplate.update(
                    INSERT_BEST_PRICE,
                    params
            );

        }

//        if (exist != 0){
////            String UPDATE_SQL;
//
//            sql = "" +
//                    "UPDATE best_price                          \n" +
//                    "SET order_qty =(                           \n" +
//                    "SELECT SUM(:orderQty+order_qty))           \n" +
//                    "WHERE :orderUV = best_price.order_uv       \n" +
//                    "AND :orderType = best_price.order_type     \n" +
//                    "AND :orderStock =best_price.order_stock"    ;
//
//            params.addValue("orderType", in.getOrderType());
//            params.addValue("orderUV", in.getOrderUV());
//            params.addValue("orderStock", in.getOrderStock());
//            params.addValue("orderQty", in.getOrderQty());
//
//
//        }

    }
}

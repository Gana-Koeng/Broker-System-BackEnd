package csx.broker.Service.bests;


import csx.broker.Entity.accounts.Account;
import csx.broker.Entity.bests.Best;
import csx.broker.Entity.broker.Broker;
import csx.broker.Repository.bests.BestRepository;
import csx.broker.Repository.broker.BrokerRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BestService {
    private final BestRepository bestRepository;
    private final BrokerRepository brokerRepository;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BestService(BestRepository bestRepository, BrokerRepository brokerRepository) {
        this.bestRepository = bestRepository;
        this.brokerRepository = brokerRepository;
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
    public void process(Broker req) {
        Best bestOrder = new Best();
        
        bestOrder.setOrderQty(req.getOrderQty());
        bestOrder.setOrderUv(Integer.parseInt(String.valueOf(req.getOrderUV())));
        bestOrder.setOrderStock(Integer.valueOf(req.getIssueCode()));
        bestOrder.setOrderType(Integer.valueOf(req.getOrderType()));

        save(bestOrder);
    }
//it to call two entity we should write in best service and broker order

    public void getExistingBestOrder(Best best) {

        String GET_BEST_PRICE = "" +
                "  SELECT COUNT(*)                     \n" +
                "  FROM best_price                     \n" +
                "  WHERE order_type = :orderType        \n" +
                "    AND order_uv = :orderUV            \n" +
                "    AND order_qty = :orderQty          \n" +
                "    AND order_stock = :orderStock      \n" +
                " ;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderType", best.getOrderType());
        params.addValue("orderUV", best.getOrderUv());
        params.addValue("orderQty", best.getOrderQty());
        params.addValue("orderStock", best.getOrderStock());

        int exist = namedParameterJdbcTemplate.queryForObject(
                GET_BEST_PRICE,
                params,
                int.class
        );

        if (exist == 0) {

            String INSERT_BEST_PRICE = "" +
                    "INSERT INTO best_price            \n" +
                    "          ( order_type            \n" +
                    "          , order_uv              \n" +
                    "          , order_qty             \n" +
                    "          , order_stock)          \n" +
                    "   VALUES (:orderType             \n" +
                    "         , :orderUV               \n" +
                    "         , :orderQty              \n" +
                    "         , :orderStock);            ";

            namedParameterJdbcTemplate.update(
                    INSERT_BEST_PRICE,
                    params
            );

        }

        if (exist != 0){
//            String UPDATE_SQL;

         String  sql = "" +
                    "UPDATE best_price                          \n" +
                    "SET order_qty =(                           \n" +
                    "SELECT SUM(:orderQty+order_qty))           \n" +
                    "WHERE :orderUV = best_price.order_uv       \n" +
                    "AND :orderType = best_price.order_type     \n" +
                    "AND :orderStock =best_price.order_stock"    ;

            params.addValue("orderType", best.getOrderType());
            params.addValue("orderUV", best.getOrderUv());
            params.addValue("orderStock", best.getOrderStock());
            params.addValue("orderQty", best.getOrderQty());


        }

    }
}

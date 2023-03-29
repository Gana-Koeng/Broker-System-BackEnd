package csx.broker.Service.bests;


//import csx.broker.Entity.accounts.Account;
import csx.broker.Entity.broker.Broker;
import csx.broker.Entity.bests.Best;
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

        bestOrder.setBestQty(String.valueOf(req.getOrderQty()));
        bestOrder.setBestUV(Integer.parseInt(String.valueOf(req.getOrderUV())));
        bestOrder.setBestStock(String.valueOf(req.getIssueCode()));
        bestOrder.setBestType(String.valueOf(req.getOrderType()));

        save(bestOrder);
    }
//it to call two entity we should write in best service and broker order

     public void getExistingBestOrder(Best in){

        String sql = "" +
                " SELECT COUNT(*)                     \n" +
                "   FROM best_price                   \n" +
                "  WHERE BEST_TYPE = :bestType        \n" +
                "    AND BEST_UV = :bestUV            \n" +
                "    AND BEST_QTY = :bestQty          \n" +
                "    AND BEST_STOCK = :bestStock      \n" +
                " ;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("bestType", in.getBestType());
        params.addValue("bestUV", in.getBestUV());
        params.addValue("bestQty", in.getBestQty());
        params.addValue("bestStock", in.getBestStock());

        int exist = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                int.class
        );

        if(exist == 0){

            sql = "" +
                    "INSERT INTO best_price (best_type, best_uv, best_qty, best_stock) \n" +
                    "VALUES (:bestType, :bestUV, :bestQty,:bestStock);";

            params.addValue("bestType", in.getBestType());
            params.addValue("bestUV", in.getBestUV());
            params.addValue("bestQty", in.getBestStock());
            params.addValue("bestStock", in.getBestQty());

            namedParameterJdbcTemplate.update(
                sql,
                params
        );

                    ;
        }

        if (exist != 0){
//            String UPDATE_SQL;

            sql = "" +
                    "INSERT INTO best_price (best_type, best_uv, best_qty, best_stock) \n" +
                    "VALUES (:bestType, :bestUV, :bestQty,:bestStock);";

            params.addValue("bestType", in.getBestType());
            params.addValue("bestUV", in.getBestUV());
            params.addValue("bestQty", in.getBestStock());
            params.addValue("bestStock", in.getBestQty());
        }

    }


}

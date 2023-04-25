package csx.broker.Repository.orders;

import csx.broker.Entity.orders.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//get all data from table broker
@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

    @Query(value = "SELECT * FROM table_order ", nativeQuery = true)
    Iterable<Order> getAllData();

}

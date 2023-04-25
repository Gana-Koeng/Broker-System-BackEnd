package csx.broker.Service.orders;



import csx.broker.Entity.orders.Order;

import csx.broker.Repository.orders.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

//    public List<String> getAllBrokerId() {
//        return brokerRepository.getAllBrokerId();
//    }
    public void save(Order order){
        orderRepository.save(order);
    }

    public void delete(int OrderNo ){
        orderRepository.deleteById(OrderNo);
    }


}

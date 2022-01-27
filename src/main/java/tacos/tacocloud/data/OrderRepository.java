package tacos.tacocloud.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.tacocloud.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
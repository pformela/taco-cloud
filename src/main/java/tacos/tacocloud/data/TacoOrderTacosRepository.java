package tacos.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import tacos.tacocloud.TacoOrderTacos;

public interface TacoOrderTacosRepository extends CrudRepository<TacoOrderTacos, Long> {
}

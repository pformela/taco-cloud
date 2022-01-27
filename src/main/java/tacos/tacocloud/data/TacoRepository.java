package tacos.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import tacos.tacocloud.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
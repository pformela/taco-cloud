package tacos.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import tacos.tacocloud.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

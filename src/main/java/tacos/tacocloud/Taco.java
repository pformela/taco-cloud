package tacos.tacocloud;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Nazwa musi się składać z przynajmniej 5 znaków")
    private String name;
    @Size(min=1, message="Musisz wybrać przynajmniej jeden składnik")
    private List<String> ingredients;
}

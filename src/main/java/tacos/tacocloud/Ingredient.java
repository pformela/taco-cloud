package tacos.tacocloud;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private final String id;
    private final String name;
    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ingredient that = (Ingredient) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

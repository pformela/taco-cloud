package tacos.tacocloud;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min=5, message="Nazwa musi się składać z przynajmniej 5 znaków")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @NotEmpty(message="Musisz wybrać przynajmniej jeden składnik")
    @ToString.Exclude
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Taco taco = (Taco) o;
        return id != null && Objects.equals(id, taco.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

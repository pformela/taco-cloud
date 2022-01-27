package tacos.tacocloud;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Taco_Order_Tacos")
@Entity
public class TacoOrderTacos {

    @Id
    private Long id;
    @Column(name="order_id")
    private long order_id;
    @Column(name="taco_id")
    private long taco_id;

    public TacoOrderTacos(Order order, Taco taco) {
        this.order_id = order.getId();
        this.taco_id = taco.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TacoOrderTacos that = (TacoOrderTacos) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

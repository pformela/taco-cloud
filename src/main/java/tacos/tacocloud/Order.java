package tacos.tacocloud;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name="placedAt")
    private Date placedAt;

    @NotBlank(message = "Podanie imienia i nazwiska jest obowiązkowe")
    private String name;

    @NotBlank(message = "Podanie ulicy jest obowiazkowe")
    private String street;

    @NotBlank(message = "Podanie miejscowosci jest obowiązkowe")
    private String city;

    @NotBlank(message = "Podanie województwa jest obowiązkowe")
    private String state;

    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe")
    private String zip;

    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
    private String ccNumber;

    @Pattern(regexp = "^((0[1-9])|(1[0-2]))/([1-9][0-9])$",
             message="Wartość musi być w formacie MM/RR")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Nieprawidłowy kod CVV.")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    @ToString.Exclude
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

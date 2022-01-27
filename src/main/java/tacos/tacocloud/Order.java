package tacos.tacocloud;

import lombok.Data;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Long id;
    private Date placedAt;

    @Size(min=2, max=50)
    @NotBlank(message = "Podanie imienia i nazwiska jest obowiązkowe")
    private String name;

    @Size(min=2, max=50)
    @NotBlank(message = "Podanie ulicy jest obowiazkowe")
    private String street;

    @Size(min=2, max=50)
    @NotBlank(message = "Podanie miejscowosci jest obowiązkowe")
    private String city;

    @Size(min=2, max=20)
    @NotBlank(message = "Podanie województwa jest obowiązkowe")
    private String state;

    @Size(min=2, max=10)
    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe")
    private String zip;

    @Size(min=16, max=16)
    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
    private String ccNumber;

    @Size(min=5, max=5)
    @Pattern(regexp = "^((0[1-9])|(1[0-2]))/([1-9][0-9])$",
             message="Wartość musi być w formacie MM/RR")
    private String ccExpiration;

    @Size(min=3, max=3)
    @Digits(integer=3, fraction=0, message="Nieprawidłowy kod CVV.")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }
}

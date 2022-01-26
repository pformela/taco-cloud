package tacos.tacocloud;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Long id;
    private Date placedAt;

    @Valid
    @NotBlank(message = "Podanie imienia i nazwiska jest obowiązkowe")
    private String name;

    @Valid
    @NotBlank(message = "Podanie ulicy jest obowiazkowe")
    private String street;

    @Valid
    @NotBlank(message = "Podanie miejscowosci jest obowiązkowe")
    private String city;

    @Valid
    @NotBlank(message = "Podanie województwa jest obowiązkowe")
    private String state;

    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe")
    private String zip;

    @Valid
    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
    private String ccNumber;

    @Valid
    @Pattern(regexp = "^((0[1-9])|(1[0-2]))/([1-9][0-9])$",
             message="Wartość musi być w formacie MM/RR")
    private String ccExpiration;

    @Valid
    @Digits(integer=3, fraction=0, message="Nieprawidłowy kod CVV.")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();
}

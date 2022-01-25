package tacos.tacocloud;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class Order {
    @NotEmpty(message = "Podanie imienia i nazwiska jest obowiązkowe")
    private String name;

    @NotEmpty(message = "Podanie ulicy jest obowiazkowe")
    private String street;

    @NotEmpty(message = "Podanie miejscowosci jest obowiązkowe")
    private String city;

    @NotEmpty(message = "Podanie województwa jest obowiązkowe")
    private String state;

    @NotEmpty(message = "Podanie kodu pocztowego jest obowiązkowe")
    private String zip;

    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]1[0-2])([\\/])([1-9][0-9])",
             message="Wartość musi być w formacie MM/RR")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Nieprawidłowy kod CVV.")
    private String ccCVV;
}

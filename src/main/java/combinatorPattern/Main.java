package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;
import static combinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Dorcas",
                "dorcas@gmail.com",
                "51421558",
                LocalDate.of(1990,12,12)
        );

        // Using Combinator pattern
        ValidationResult results = isEmailValid()
                .and(isAdult())
                .and(isPhoneNumberValid())
                .apply(customer);

        System.out.println(results);
        if (results != SUCCESS)
            throw new IllegalStateException(results.name());
    }
}

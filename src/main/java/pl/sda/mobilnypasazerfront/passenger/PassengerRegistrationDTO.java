package pl.sda.mobilnypasazerfront.passenger;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PassengerRegistrationDTO {

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\-\\=]).{6,20})";

    @Size(min=3, max=15, message = "Imie powinno miec od 3 do 15 znakow")
    private String firstName;
    @Size(min=3, max=25, message = "Nazwisko powinno miec od 3 do 25 znakow")
    private String lastName;
    @NotNull(message = "Pole nie może być puste")
    private Sex sex;
    @Email(message = "Pole powinno zawierać poprawny adres email")
    private String username;
    @NotNull(message = "Pole nie może być puste")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Hasło musi zawierać od 6 do 20 znaków oraz: \n" +
                                                " conajmniej jedną cyfrę,\n" +
                                                " conajmniej jedną małą literę,\n" +
                                                " conajmniej jedną dużą literę,\n" +
                                                " conajmniej jeden znak specjalny z grupy !@#$%^&*()_+-=\n")
    private String password;
    @Pattern(regexp = "\\d{11}", message = "Numer telefonu musi składać się z 11 cyfr")
    private String phone;
}
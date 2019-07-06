package pl.sda.mobilnypasazerfront.passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sex {
    MAN("Mężczyzna"),
    WOMAN("Kobieta");

    String plName;

}
package pl.sda.mobilnypasazerfront.passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sex {
    MEN("Mężczyzna"),
    WOMAN("Kobieta");

    String plName;

}
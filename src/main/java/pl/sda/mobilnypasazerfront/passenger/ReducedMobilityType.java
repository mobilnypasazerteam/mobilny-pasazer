package pl.sda.mobilnypasazerfront.passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReducedMobilityType {

    WHEEL_CHAIR ("Osoba na wózku ręcznym"),
    ELECTRIC_WHEELCHAIR ("Osoba na wózku elektrycznym"),
    BLIND_PERSON ("Osoba niewidoma"),
    DEAF_PERSON ("Osoba głucha"),
    PERSON_WITH_CRUTCHES("Osoba o kulach"),
    ELDER_PERSON("Osoba starsza"),
    SMALL_CHILD ("Osoba z dzieckiem w wózku/ z małym dzieckiem do lat 4"),
    OTHER ("Inne");

    String label;
}

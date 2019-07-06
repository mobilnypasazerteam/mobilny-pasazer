package pl.sda.mobilnypasazerfront.passenger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassengerElevator {

    private long id;
    private String station;
    private String platform;
    private String malfunction_date;
    private String action_taken;
    private String planned_malfunction_end;
    private String malfunction_end;
}



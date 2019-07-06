package pl.sda.mobilnypasazerfront.passenger;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerTicketDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Pole nie może być puste")
    private String phone;
    @Email
    @NotNull(message = "Pole nie może być puste")
    private String email;
    @NotNull(message = "Pole nie może być puste")
    private String travelDate;
    @NotNull(message = "Pole nie może być puste")
    private String startPoint;
    @NotNull(message = "Pole nie może być puste")
    private String startTime;
    private String intermediatePoint;
    @NotNull(message = "Pole nie może być puste")
    private String endPoint;
    @NotNull(message = "Pole nie może być puste")
    private String endTime;
    @NotNull(message = "Pole nie może być puste")
    private Integer passengerNo;
    private String reducedMobilityType;
    private String additionalInfo;

}

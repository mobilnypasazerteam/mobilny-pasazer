package pl.sda.mobilnypasazerfront.passenger;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class PassengerTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String phone;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String travelDate;
    @NotNull
    private String startPoint;
    @NotNull
    private String startTime;
    private String intermediatePoint;
    @NotNull
    private String endPoint;
    @NotNull
    private String endTime;
    @NotNull
    private Integer passengerNo;
    private String reducedMobilityType;
    private String additionalInfo;
   }
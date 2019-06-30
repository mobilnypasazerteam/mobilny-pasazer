package pl.sda.mobilnypasazerfront.passenger;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
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
    private String travel_date;
    @NotNull(message = "Pole nie może być puste")
    private String start_point;
    @NotNull(message = "Pole nie może być puste")
    private String start_time;
    private String intermediate_point;
    @NotNull(message = "Pole nie może być puste")
    private String end_point;
    @NotNull(message = "Pole nie może być puste")
    private String end_time;
    @NotNull(message = "Pole nie może być puste")
    private Integer passenger_no;
    private String reduced_mobility_type;
    @Size(min=3, max=50, message = "maksymalnie 50 znaków")
    private String additional_info;

}

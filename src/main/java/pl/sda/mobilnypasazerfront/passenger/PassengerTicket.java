package pl.sda.mobilnypasazerfront.passenger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class PassengerTicket {

    private String phone;
    @Email
    private String email;
    private String travel_date;
    private String start_point;
    private String start_time;
    private String intermediate_point;
    private String end_point;
    private String end_time;
    private Integer passenger_no;
    private String reduced_mobility_type;
    @Size(min=3, max=50, message = "maksymalnie 50 znaków")
    private String additional_info;

}

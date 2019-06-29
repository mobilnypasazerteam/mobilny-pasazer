package pl.sda.mobilnypasazerfront.passenger;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "passengers")
public class PassengerTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
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
    private String travel_date;
    @NotNull
    private String start_point;
    @NotNull
    private String start_time;
    private String intermediate_point;
    @NotNull
    private String end_point;
    @NotNull
    private String end_time;
    @NotNull
    private Integer passenger_no;
    private String reduced_mobility_type;
    private String additional_info;
   }
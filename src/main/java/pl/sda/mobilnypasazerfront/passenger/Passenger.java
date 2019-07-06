package pl.sda.mobilnypasazerfront.passenger;

import lombok.*;
import pl.sda.mobilnypasazerfront.BaseEntity;
import pl.sda.mobilnypasazerfront.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {

    private String firstName;
    private String lastName;
    private Sex sex;
    private String username;
    private String passwordHash;
    private String phone;

    @ManyToMany
    @JoinTable(name = "passengers_roles")
    private Set<Role> roles = new HashSet<>();
}
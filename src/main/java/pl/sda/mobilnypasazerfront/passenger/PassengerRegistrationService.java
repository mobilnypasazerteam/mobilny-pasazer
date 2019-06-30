package pl.sda.mobilnypasazerfront.passenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.mobilnypasazerfront.roles.Role;
import pl.sda.mobilnypasazerfront.roles.RoleRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class PassengerRegistrationService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void registerUser(PassengerRegistrationDTO dto) {
        Passenger passenger = dtoToEntity(dto);
        if (passengerRepository.existsByUsername(passenger.getUsername())) {
            throw new RuntimeException("User with email: "
                    + passenger.getUsername() + " exists");
        } else {
            passengerRepository.save(passenger);
        }
    }

    private Passenger dtoToEntity(PassengerRegistrationDTO dto) {
        Role userRole = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> supportedRoles = new HashSet<>();
        supportedRoles.add(userRole);
        return Passenger.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .sex(dto.getSex())
                .username(dto.getUsername())
                .phone(dto.getPhone())
                .roles(supportedRoles)
                .passwordHash(encoder.encode(dto.getPassword()))
                .build();

    }
}


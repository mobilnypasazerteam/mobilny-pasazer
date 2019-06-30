package pl.sda.mobilnypasazerfront.passenger;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.mobilnypasazerfront.roles.RoleRepository;

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

        return Passenger.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .sex(dto.getSex())
                .username(dto.getUsername())
                .phone(dto.getPhone())
                .roles(Sets.newHashSet(
                        roleRepository.findByRoleName("ROLE_USER")))
                .passwordHash(encoder.encode(dto.getPassword()))
                .build();

    }
}


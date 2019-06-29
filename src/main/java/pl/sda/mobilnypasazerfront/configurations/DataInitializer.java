package pl.sda.mobilnypasazerfront.configurations;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.mobilnypasazerfront.passenger.Passenger;
import pl.sda.mobilnypasazerfront.roles.Role;
import pl.sda.mobilnypasazerfront.roles.RoleRepository;
import pl.sda.mobilnypasazerfront.passenger.PassengerRepository;

@Component
public class DataInitializer implements InitializingBean {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (roleRepository.count() == 0) {
            Role role_user = roleRepository.save(new Role("ROLE_USER"));
            Role role_admin = roleRepository.save(new Role("ROLE_ADMIN"));
            Passenger passengerAdmin = Passenger.builder()
                    .username("admin@pl.pl")
                    .passwordHash(passwordEncoder.encode("admin"))
                    .roles(Sets.newHashSet(role_admin))
                    .build();
            passengerRepository.save(passengerAdmin);
            Passenger passenger = Passenger.builder()
                    .username("user@pl.pl")
                    .passwordHash(passwordEncoder.encode("user"))
                    .roles(Sets.newHashSet(role_user))
                    .build();
            passengerRepository.save(passenger);
        }
    }
}
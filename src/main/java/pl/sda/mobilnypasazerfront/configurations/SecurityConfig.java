package pl.sda.mobilnypasazerfront.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll() //kolejność jest ważna - elementy wyższe nadpisują niższe
                .antMatchers("/login").permitAll()
                .antMatchers("/profile").permitAll()
                .antMatchers("/css/**").permitAll() //odblokowujemy dostęp do zasobow statycznych
                .antMatchers("/api/**").permitAll() //odblokowujemy dostęp do zasobow statycznych
                .antMatchers("/users/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .anyRequest().permitAll()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("loginEmail")
                .passwordParameter("loginPassword")
                .loginProcessingUrl("/processLogin")
                .failureUrl("/login?error=1")
                .defaultSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery(
                        "SELECT p.username, p.password_hash, 1 " +
                                "FROM passengers p " +
                                "WHERE p.username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT p.username, r.role_name, 1 " +
                                "FROM passengers p " +
                                "JOIN passengers_roles pr ON p.id = pr.passenger_id " +
                                "JOIN roles r ON pr.roles_id = r.id " +
                                "WHERE p.username = ? ")
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource);
    }}

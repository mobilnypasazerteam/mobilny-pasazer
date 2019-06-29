package pl.sda.mobilnypasazerfront.roles;

import lombok.NoArgsConstructor;
import pl.sda.mobilnypasazerfront.BaseEntity;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity {

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
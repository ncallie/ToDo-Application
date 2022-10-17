package ru.ncallie.ToDo.models;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity(name = "usr")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;

    @ElementCollection(targetClass = Role.class, fetch = EAGER)
    @CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "usr_id"))
    @Enumerated(STRING)
    private Set<Role> roles;

    //Mail Sender
    private boolean isActive;
    private String activationCode;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

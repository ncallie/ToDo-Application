package ru.ncallie.ToDo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ncallie.ToDo.models.Role;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutRegistrationDTO {
    private Long id;
    private String username;
    private String email;
    private Set<Role> roles;
}

package ru.ncallie.ToDo.services;

import ru.ncallie.ToDo.models.User;
import ru.ncallie.ToDo.models.dto.OutRegistrationDTO;

public interface SecurityService {
    OutRegistrationDTO registration(User user);
    String authentication(User user);
    void confirmActivationCode(String username, String code);
}

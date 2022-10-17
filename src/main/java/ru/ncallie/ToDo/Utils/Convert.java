package ru.ncallie.ToDo.Utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import ru.ncallie.ToDo.models.User;
import ru.ncallie.ToDo.models.dto.AuthenticationDTO;
import ru.ncallie.ToDo.models.dto.InRegistrationDTO;
import ru.ncallie.ToDo.models.dto.OutRegistrationDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Convert {

    private final ModelMapper modelMapper;

    public User toUser(InRegistrationDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public OutRegistrationDTO toOutRegistration(User user) {
        return modelMapper.map(user, OutRegistrationDTO.class);
    }

    public User toUser(AuthenticationDTO authenticationDTO) {
        return modelMapper.map(authenticationDTO, User.class);
    }

    public Map<String, List<String>> toMessages(BindingResult bindingResult) {
        Map<String, List<String>> errors = new HashMap<>();
        for (ObjectError error : bindingResult.getAllErrors()) {
            String field = ((FieldError) error).getField();
            if (errors.containsKey(field))
                errors.get(field).add(error.getDefaultMessage());
            else
                errors.put(field, new ArrayList<>(){{add(error.getDefaultMessage());}});
        }
        return errors;
    }
}

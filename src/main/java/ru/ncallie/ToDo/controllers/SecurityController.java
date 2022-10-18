package ru.ncallie.ToDo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ncallie.ToDo.Utils.Convert;
import ru.ncallie.ToDo.models.User;
import ru.ncallie.ToDo.models.dto.AuthenticationDTO;
import ru.ncallie.ToDo.models.dto.InRegistrationDTO;
import ru.ncallie.ToDo.services.SecurityService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class SecurityController {

    private final SecurityService securityService;
    private final Convert convert;

    @PostMapping("/registration")
    public ResponseEntity registerUserAccount(@RequestBody @Valid InRegistrationDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(convert.toMessages(bindingResult));
        User user = convert.toUser(userDTO);;
        return ResponseEntity.status(HttpStatus.CREATED).body(securityService.registration(user));
    }

    @PostMapping("/authentication")
    public ResponseEntity authenticationUserAccount(@RequestBody @Valid AuthenticationDTO authenticationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(convert.toMessages(bindingResult));
        String jwtToken = securityService.authentication(convert.toUser(authenticationDTO));
       return ResponseEntity.ok().body(Map.of("jwt-token", jwtToken));
    }

    @GetMapping("/activate/{username}/{code}")
        public ResponseEntity confirmActivationCode(@PathVariable("username") String username, @PathVariable("code") String code) {
        securityService.confirmActivationCode(username, code);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

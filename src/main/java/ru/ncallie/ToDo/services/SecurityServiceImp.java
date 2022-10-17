package ru.ncallie.ToDo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ncallie.ToDo.Exceptions.DataInUseException;
import ru.ncallie.ToDo.Exceptions.InvalidActivationCodeException;
import ru.ncallie.ToDo.Exceptions.InvalidPasswordException;
import ru.ncallie.ToDo.Utils.Convert;
import ru.ncallie.ToDo.configuration.mail.MailSender;
import ru.ncallie.ToDo.configuration.security.jwt.JWTUtil;
import ru.ncallie.ToDo.models.Role;
import ru.ncallie.ToDo.models.User;
import ru.ncallie.ToDo.models.dto.OutRegistrationDTO;
import ru.ncallie.ToDo.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SecurityServiceImp implements SecurityService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Convert convert;
    private final JWTUtil jwtUtil;
    private final MailSender mailSender;

    @Transactional
    @Override
    public OutRegistrationDTO registration(User user) {
        validation(user);
        user.setRoles(new HashSet<>(){{add(Role.ROLE_USER);}});
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setActivationCode(UUID.randomUUID().toString());
        mailSender.send(user.getEmail(),
                    "Activation code",
                    String.format("Hello %s !\n Welcome to ToDo\n Please, visit next link: http://localhost:8080/api/users/activate/%s", user.getUsername(), user.getActivationCode()));
        return convert.toOutRegistration(userRepository.save(user));
    }


    @Override
    public String authentication(User user) {
        Optional<User> userDbOpt = userRepository.getUserByUsername(user.getUsername());
        if (userDbOpt.isEmpty())
            throw new UsernameNotFoundException("Username " + user.getUsername() + " not found");
        if (passwordEncoder.matches(user.getPassword(), userDbOpt.get().getPassword()))
            return jwtUtil.generateToken(user.getUsername());
        throw new InvalidPasswordException("Invalid password");
    }

    @Transactional
    @Override
    public void confirmActivationCode(String code) {
        User user = userRepository.getUserByActivationCode(code).orElseThrow(() -> new InvalidActivationCodeException("Invalid activation code"));
        user.setActivationCode("");
        user.setActive(true);
        userRepository.save(user);
    }

    private void validation(User user) {
        if (userRepository.getUserByUsername(user.getUsername()).isPresent())
            throw new DataInUseException("Username " + user.getUsername() + " is already in use.");
        if (userRepository.getUserByEmail(user.getEmail()).isPresent())
            throw new DataInUseException("Email " + user.getEmail() + " is already in use.");
    }
}

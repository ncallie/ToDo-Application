package ru.ncallie.ToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ncallie.ToDo.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByActivationCode(String activationConde);
}

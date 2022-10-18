package ru.ncallie.ToDo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ncallie.ToDo.models.Task;
import ru.ncallie.ToDo.models.User;
import ru.ncallie.ToDo.repositories.TaskRepository;
import ru.ncallie.ToDo.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Page<Task> findAll(int page, int size, User user) {
//        TODO lazy init dont work
//        User userDB = userRepository.getUserByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username " + user.getUsername() + " not found"));
//        PageRequest pr = PageRequest.of(page, size);
//        return taskRepository.findByOwner(userDB, pr);
        return null;
    }
}

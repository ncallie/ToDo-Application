package ru.ncallie.ToDo.services;

import org.springframework.data.domain.Page;
import ru.ncallie.ToDo.models.Task;
import ru.ncallie.ToDo.models.User;

public interface TaskService {
    Page<Task> findAll(int page, int size, User user);
}

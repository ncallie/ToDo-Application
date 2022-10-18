package ru.ncallie.ToDo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncallie.ToDo.models.Task;
import ru.ncallie.ToDo.models.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByOwner(User owner, Pageable pageable);
}

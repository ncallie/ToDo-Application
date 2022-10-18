package ru.ncallie.ToDo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ncallie.ToDo.models.Task;
import ru.ncallie.ToDo.models.User;
import ru.ncallie.ToDo.services.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public Page<Task> findAll(@RequestParam(required = false, defaultValue = "0") int page,
                              @RequestParam(required = false, defaultValue = "10") int size,
                              @AuthenticationPrincipal User user) {
        return taskService.findAll(page, size, user);
    }

}

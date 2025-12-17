package com.example.taskapi.controller;

import com.example.taskapi.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import com.example.taskapi.exception.TaskNotFoundException;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final Map<Long, Task> store = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    public Task createTask(@RequestBody @Valid Task task) {
        long id = idGenerator.getAndIncrement();
        Task created = new Task(id, task.title(), task.done());
        store.put(id, created);
        return created;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
    Task task = store.get(id);
    if(task == null) {
        throw new TaskNotFoundException(id);
    }
    return task;
    }
}
//    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//        Task task = store.get(id);
//        if (task == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(task);
//    }
//}

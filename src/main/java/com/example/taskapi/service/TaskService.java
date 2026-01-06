package com.example.taskapi.service;

import com.example.taskapi.exception.TaskNotFoundException;
import com.example.taskapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

@Service
public class TaskService {

    private final Map<Long, Task> store = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Task create(Task task) {
        long id = idGenerator.getAndIncrement();
        Task created = new Task(id, task.title(), task.done());
        store.put(id, created);
        return created;
    }

    public Task getById(Long id) {
        Task task = store.get(id);
        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    public List<Task> getAll() {
        return List.copyOf(store.values());
    }

    public Task toggleDone(Long id) {
        Task existing = getById(id); // tek otorite

        Task updated = new Task(
                existing.id(),
                existing.title(),
                !existing.done()
        );
        store.put(id, updated);
        return updated;
    }
}

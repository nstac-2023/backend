package pl.edu.pb.todobackend.controllers.operations;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pb.todobackend.controllers.requests.CreateSubtaskRequest;
import pl.edu.pb.todobackend.controllers.requests.CreateTaskRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTaskRequest;

@RequestMapping("/todo-lists/{list-id}/tasks")
public interface TaskApi {

  @PostMapping
  ResponseEntity<Void> createTask(@PathVariable("list-id") UUID listId,
      @RequestBody CreateTaskRequest request);

  @DeleteMapping("/{task-id}")
  ResponseEntity<Void> deleteTask(@PathVariable("list-id") UUID listId,
      @PathVariable("task-id") UUID taskId);

  @PatchMapping("/{task-id}")
  ResponseEntity<Void> updateTask(@PathVariable("list-id") UUID listId,
      @PathVariable("task-id") UUID taskId,
      @RequestBody UpdateTaskRequest request);

  @PatchMapping("/{task-id}/subtasks")
  ResponseEntity<Void> createSubtask(@PathVariable("list-id") UUID listId,
      @PathVariable("task-id") UUID taskId,
      @RequestBody CreateSubtaskRequest request);

  @DeleteMapping("/{task-id}/subtasks/{subtask-id}")
  ResponseEntity<Void> deleteSubtask(@PathVariable("list-id") UUID listId,
      @PathVariable("task-id") UUID taskId,
      @PathVariable("subtask-id") UUID id);
}

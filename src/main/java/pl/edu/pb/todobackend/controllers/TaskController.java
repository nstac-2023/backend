package pl.edu.pb.todobackend.controllers;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pb.todobackend.controllers.operations.TaskApi;
import pl.edu.pb.todobackend.controllers.repositories.TodoListRepository;
import pl.edu.pb.todobackend.controllers.requests.CreateSubtaskRequest;
import pl.edu.pb.todobackend.controllers.requests.CreateTaskRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTaskRequest;
import pl.edu.pb.todobackend.model.TodoList;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

  private final TodoListRepository repository;


  @Override
  public ResponseEntity<Void> createTask(UUID listId, CreateTaskRequest request) {
    var todolist = getTodoList(listId);
    todolist.addTask(request.name(), request.deadline());
    repository.save(todolist);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> deleteTask(UUID listId, UUID taskId) {
    var todolist = getTodoList(listId);
    todolist.removeTask(taskId);
    repository.save(todolist);

    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> updateTask(UUID listId, UUID taskId, UpdateTaskRequest request) {
    var todolist = getTodoList(listId);
    todolist.updateTask(taskId, request);
    repository.save(todolist);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> createSubtask(UUID listId, UUID taskId,
      CreateSubtaskRequest request) {
    var todoList = getTodoList(listId);
    todoList.getTask(taskId).addSubtask(request);
    repository.save(todoList);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> deleteSubtask(UUID listId, UUID taskId, UUID subtaskId) {
    var todoList = getTodoList(listId);
    todoList.getTask(taskId).removeSubtask(subtaskId);
    repository.save(todoList);

    return ResponseEntity.noContent().build();
  }

  TodoList getTodoList(UUID id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Todolist not exists"));
  }
}

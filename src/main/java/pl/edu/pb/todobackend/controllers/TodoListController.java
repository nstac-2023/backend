package pl.edu.pb.todobackend.controllers;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pb.todobackend.controllers.operations.TodoListApi;
import pl.edu.pb.todobackend.controllers.repositories.TodoListRepository;
import pl.edu.pb.todobackend.controllers.requests.CreateTodoListRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTodoListRequest;
import pl.edu.pb.todobackend.model.TodoList;

@RestController
@AllArgsConstructor
public class TodoListController implements TodoListApi {

  private final TodoListRepository repository;

  @Override
  public ResponseEntity<Void> create(CreateTodoListRequest request) {
    var todoList = TodoList.from(request);
    repository.save(todoList);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<List<TodoList>> findAll() {
    return ResponseEntity.ok(repository.findAll());
  }

  @Override
  public ResponseEntity<TodoList> find(UUID listId) {
    return ResponseEntity.ok(getTodoList(listId));
  }

  @Override
  public ResponseEntity<Void> update(UUID id, UpdateTodoListRequest request) {
    var todoList = getTodoList(id);
    todoList.update(request);
    repository.save(todoList);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> delete(UUID id) {
    var todoList = getTodoList(id);
    repository.delete(todoList);

    return ResponseEntity.noContent().build();
  }

  private TodoList getTodoList(UUID id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Todolist not exists"));
  }
}

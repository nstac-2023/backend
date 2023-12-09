package pl.edu.pb.todobackend.controllers.operations;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pb.todobackend.controllers.requests.CreateTodoListRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTodoListRequest;
import pl.edu.pb.todobackend.model.TodoList;

@RequestMapping("/todo-lists")
public interface TodoListApi {

  @PostMapping
  ResponseEntity<Void> create(@RequestBody CreateTodoListRequest request);

  @GetMapping
  ResponseEntity<List<TodoList>> findAll();

  @GetMapping("/{id}")
  ResponseEntity<TodoList> find(@PathVariable("id") UUID listId);

  @PatchMapping("/{id}")
  ResponseEntity<Void> update(@PathVariable("id") UUID id,
      @RequestBody UpdateTodoListRequest request);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> delete(@PathVariable("id") UUID id);
}

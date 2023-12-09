package pl.edu.pb.todobackend.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import pl.edu.pb.todobackend.controllers.requests.CreateTodoListRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTaskRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTodoListRequest;

@Getter
@Entity
@Table(name = "todo_list")
@NoArgsConstructor
public class TodoList {

  @Id
  private UUID id;

  private String name;

  @Type(JsonType.class)
  @Column(columnDefinition = "json")
  private List<Task> tasks;

  @Enumerated(EnumType.STRING)
  private TodoListCategory category;

  private TodoList(String name, TodoListCategory category) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.category = category;
    this.tasks = new ArrayList<>();
  }

  public static TodoList from(CreateTodoListRequest request) {
    return new TodoList(request.name(), request.category());
  }

  public void update(UpdateTodoListRequest request) {
    this.name = request.name();
    this.category = request.category();
  }

  public void addTask(String name, LocalDate deadline) {
    tasks.add(Task.of(name, deadline));
  }

  public void removeTask(UUID id) {
    tasks.removeIf(task -> task.getId().equals(id));
  }

  public void updateTask(UUID taskId, UpdateTaskRequest request) {
    getTask(taskId).update(request);
  }

  public Task getTask(UUID taskId) {
    return tasks.stream()
        .filter(task -> task.getId().equals(taskId))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Task does not exist"));
  }
}

package pl.edu.pb.todobackend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.edu.pb.todobackend.controllers.requests.CreateSubtaskRequest;
import pl.edu.pb.todobackend.controllers.requests.UpdateTaskRequest;

@Getter
@NoArgsConstructor
public class Task {

  private UUID id;
  private String name;
  private LocalDate deadline;
  private boolean done;
  private List<Subtask> subtasks;

  private Task(String name, LocalDate deadline) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.deadline = deadline;
    this.done = false;
    this.subtasks = new ArrayList<>();
  }

  public static Task of(String name, LocalDate deadline) {
    return new Task(name, deadline);
  }

  public void update(UpdateTaskRequest request) {
    this.name = request.name();
    this.deadline = request.deadline();
    this.done = request.done();
  }

  public void addSubtask(CreateSubtaskRequest request) {
    subtasks.add(Subtask.of(request.name(), request.deadline()));
  }

  public void removeSubtask(UUID id) {
    subtasks.removeIf(task -> task.getId().equals(id));
  }
}

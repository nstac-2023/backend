package pl.edu.pb.todobackend.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
class Subtask {

  private UUID id;
  private String name;
  private boolean done;
  private LocalDate deadline;

  private Subtask(String name, LocalDate deadline) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.deadline = deadline;
    this.done = false;
  }

  public static Subtask of(String name, LocalDate deadline) {
    return new Subtask(name, deadline);
  }
}

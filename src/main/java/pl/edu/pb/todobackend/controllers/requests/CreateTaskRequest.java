package pl.edu.pb.todobackend.controllers.requests;

import java.time.LocalDate;

public record CreateTaskRequest(String name, LocalDate deadline) {

}

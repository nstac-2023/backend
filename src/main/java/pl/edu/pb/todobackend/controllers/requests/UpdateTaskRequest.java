package pl.edu.pb.todobackend.controllers.requests;

import java.time.LocalDate;

public record UpdateTaskRequest(String name, LocalDate deadline, boolean done) {

}

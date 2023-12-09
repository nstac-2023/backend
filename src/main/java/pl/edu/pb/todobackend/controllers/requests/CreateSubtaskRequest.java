package pl.edu.pb.todobackend.controllers.requests;

import java.time.LocalDate;

public record CreateSubtaskRequest(String name, LocalDate deadline) {

}

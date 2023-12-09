package pl.edu.pb.todobackend.controllers.requests;

import pl.edu.pb.todobackend.model.TodoListCategory;

public record UpdateTodoListRequest(String name, TodoListCategory category) {

}

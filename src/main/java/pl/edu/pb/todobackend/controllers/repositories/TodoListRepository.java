package pl.edu.pb.todobackend.controllers.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pb.todobackend.model.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, UUID> {

}

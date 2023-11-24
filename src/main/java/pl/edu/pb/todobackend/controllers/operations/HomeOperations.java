package pl.edu.pb.todobackend.controllers.operations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface HomeOperations {

    @GetMapping("/")
    ResponseEntity<String> helloWorld();

}

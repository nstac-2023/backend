package pl.edu.pb.todobackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pb.todobackend.controllers.operations.HomeOperations;

@RestController
public class HomeController implements HomeOperations {

    @Override
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }

}

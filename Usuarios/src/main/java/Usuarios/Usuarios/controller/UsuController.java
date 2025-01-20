package Usuarios.Usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Usuarios.Usuarios.model.UsuarioModel;
import Usuarios.Usuarios.service.UsuService;

@RestController
@RequestMapping("/users")
public class UsuController {

    private final UsuService usuService;
    private final KafkaProducerService kafkaProducerService; // Asumiendo que existe este servicio

    @Autowired
    public UsuController(UsuService usuService, KafkaProducerService kafkaProducerService) {
        this.usuService = usuService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> createUser(@RequestBody UsuarioModel user) {
        // Llama al método createUser del servicio
        UsuarioModel createdUser = usuService.createUser(user);

        // Envía un mensaje al KafkaProducerService
        kafkaProducerService.sendMessage("users", "New user created: " + user.getName());

        // Devuelve la respuesta HTTP con el usuario creado
        return ResponseEntity.ok(createdUser);
    }
}

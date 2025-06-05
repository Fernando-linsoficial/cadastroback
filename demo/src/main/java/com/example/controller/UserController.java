package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // para permitir requisições externas, útil no dev frontend local
public class UserController {

    private final UserService service;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService service) {
        this.service = service;
    }
@PostMapping
public ResponseEntity<User> criar(@RequestBody User usuario) {
    System.out.println("Campo imagemfacial (objeto User): " + usuario.getImagemfacial());
    if (usuario.getImagemfacial() != null) {
        System.out.println("Tipo do campo: " + usuario.getImagemfacial().getClass().getName());
    }
    User salvo = service.salvar(usuario);
    return ResponseEntity.ok(salvo);
}


    @GetMapping
    public ResponseEntity<List<User>> listar() {
        List<User> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscar(@PathVariable Long id) {
        User usuario = service.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar usuário com id {}: {}", id, e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}

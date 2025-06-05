package com.example.controller;

import com.example.model.user;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // permite acesso externo, útil para testes com frontend local
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public user criar(@RequestBody user usuario) {
        return service.salvar(usuario);
    }

    @GetMapping
    public List<user> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public user buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

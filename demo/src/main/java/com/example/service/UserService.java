package com.example.service;

import com.example.model.user;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public user salvar(user usuario) {
        return repository.save(usuario);
    }

    public List<user> listarTodos() {
        return repository.findAll();
    }

    public user buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

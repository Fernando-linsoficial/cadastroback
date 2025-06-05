package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User salvar(User usuario) {
        logger.info("Salvando usuário: {}", usuario.getNome());
        return repository.save(usuario);
    }

    public List<User> listarTodos() {
        logger.info("Buscando todos os usuários");
        return repository.findAll();
    }

    public User buscarPorId(Long id) {
        logger.info("Buscando usuário por ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        logger.info("Deletando usuário por ID: {}", id);
        repository.deleteById(id);
    }
}

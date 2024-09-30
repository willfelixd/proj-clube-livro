package com.aula.service;

import com.aula.dto.UserDto;
import com.aula.model.User;
import com.aula.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registrarUsuario(User users) {
        userRepository.save(users);
    }


    public User buscarUsuarioPorId(Integer id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id do usuário inválido " + id));
        return user;
    }

    public void atualizarUsuario(Integer id, User user) {
        userRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id do usuário inválido " + id));
        user.setId(id);

        userRepository.save(user);
    }

    public void deletarUsuario(Integer id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id do usuário inválido " + id));

        userRepository.delete(user);
    }

    public void atualizarNome(Integer id, UserDto userDto) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id do usuário inválido " + id));

        user.setNome(userDto.getNome());

        userRepository.save(user);
    }
}

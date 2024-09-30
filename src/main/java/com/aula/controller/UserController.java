package com.aula.controller;

import com.aula.dto.UserDto;
import com.aula.model.User;
import com.aula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registrar")
    public String registrarUsuario(@RequestBody User users){
        userService.registrarUsuario(users);

        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping("/id")
    public User buscarUsuarioPorId(@RequestParam Integer id){
        return userService.buscarUsuarioPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarUsuario(@PathVariable Integer id,
                                                 @RequestBody User user){
        userService.atualizarUsuario(id, user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        userService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/atualizar-nome/{id}")
    public ResponseEntity<Void> atualizarNome(@PathVariable Integer id, @RequestBody
                                              UserDto userDto){
        userService.atualizarNome(id, userDto);

        return ResponseEntity.noContent().build();
    }

}

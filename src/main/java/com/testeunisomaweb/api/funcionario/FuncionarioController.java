package com.testeunisomaweb.api.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDTO> getFuncionarios() {
        return this.funcionarioService.getFuncionarios();
    }

    @PostMapping
    public FuncionarioDTO cadastrarFuncionario(final @Valid @RequestBody FuncionarioEntity funcionario) {
        return this.funcionarioService.cadastrarFuncionario(funcionario);
    }

}
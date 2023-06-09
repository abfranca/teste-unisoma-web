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

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getFuncionarios() {
        return new ResponseEntity<List<FuncionarioDTO>>(this.funcionarioService.getFuncionarios(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> cadastrarFuncionario(final @RequestBody FuncionarioEntity funcionario) {
        return new ResponseEntity<FuncionarioDTO>(this.funcionarioService.cadastrarFuncionario(funcionario),
                HttpStatus.CREATED);
    }

}
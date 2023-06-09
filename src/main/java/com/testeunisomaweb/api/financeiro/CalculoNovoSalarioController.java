package com.testeunisomaweb.api.financeiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionarios/atualizar_salario")
public class CalculoNovoSalarioController {

    @Autowired
    private CalculoNovoSalarioService calculoNovoSalarioService;

    @PostMapping
    public ResponseEntity<Object> atualizarSalario(final @RequestBody String cpf) {
        return new ResponseEntity<Object>(this.calculoNovoSalarioService.atualizarSalario(cpf),
                HttpStatus.OK);
    }

}

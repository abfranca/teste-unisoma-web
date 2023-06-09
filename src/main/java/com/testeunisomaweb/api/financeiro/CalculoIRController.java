package com.testeunisomaweb.api.financeiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionarios/calcular_ir")
public class CalculoIRController {

    @Autowired
    private CalculoIRService calculoIRService;

    @PostMapping
    public ResponseEntity<Object> calcularIR(final @RequestBody String cpf) {
        return new ResponseEntity<Object>(this.calculoIRService.calcularIR(cpf),
                HttpStatus.OK);
    }

}

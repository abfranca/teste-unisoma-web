package com.testeunisomaweb.api.financeiro;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeunisomaweb.api.funcionario.FuncionarioDTO;
import com.testeunisomaweb.api.funcionario.FuncionarioService;
import com.testeunisomaweb.api.utils.Utils;

@Service
public class CalculoIRService {

    @Autowired
    private FuncionarioService funcionarioService;

    public Object calcularIR(String cpf) {
        FuncionarioDTO funcionario = this.funcionarioService.getFuncionarioPeloCpf(cpf);
        Map<String, Object> object = new HashMap<>();
        object.put("CPF", funcionario.getCpf());
        object.put("Imposto", this.calculoIR(funcionario.getSalario()));
        return object;
    }

    private String calculoIR(double salario) {
        double valor = salario;
        double imposto = 0;
        if (valor > 4500) {
            imposto += (valor - 4500) * 0.28;
            valor = 4500;
        }
        if (valor > 3000) {
            imposto += (valor - 3000) * 0.18;
            valor = 3000;
        }
        if (valor > 2000) {
            imposto += (valor - 2000) * 0.18;
            valor = 2000;
        }
        if (imposto == 0) {
            return "Isento";
        } else {
            return "R$ " + Utils.valorFormatado(imposto);
        }
    }

}

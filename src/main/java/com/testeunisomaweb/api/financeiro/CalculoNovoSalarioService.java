package com.testeunisomaweb.api.financeiro;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeunisomaweb.api.funcionario.FuncionarioDTO;
import com.testeunisomaweb.api.funcionario.FuncionarioService;
import com.testeunisomaweb.api.utils.Utils;

@Service
public class CalculoNovoSalarioService {

    @Autowired
    private FuncionarioService funcionarioService;

    public Object atualizarSalario(String cpf) {
        FuncionarioDTO funcionario = this.funcionarioService.getFuncionarioPeloCpf(cpf);
        double percentual = this.getPercentual(funcionario.getSalario());
        double reajuste = this.getReajuste(funcionario.getSalario(), percentual);
        double novoSalario = this.getNovoSalario(funcionario.getSalario(), reajuste);
        this.funcionarioService.atualizarSalarioFuncionario(cpf, novoSalario);
        Map<String, Object> object = new HashMap<>();
        object.put("CPF", funcionario.getCpf());
        object.put("Novo salario", Utils.valorFormatado(novoSalario));
        object.put("Reajuste ganho", Utils.valorFormatado(reajuste));
        object.put("Em percentual", Utils.valorFormatado(percentual * 100).split("\\.")[0] + " %");
        return object;
    }

    private double getPercentual(double salario) {
        double percentual = 0;
        if (salario <= 400) {
            percentual = 0.15;
        } else if (salario <= 800) {
            percentual = 0.12;
        } else if (salario <= 1200) {
            percentual = 0.1;
        } else if (salario <= 2000) {
            percentual = 0.07;
        } else {
            percentual = 0.04;
        }
        return percentual;
    }

    private double getReajuste(double salario, double percentual) {
        return salario * percentual;
    }

    private double getNovoSalario(double salario, double reajuste) {
        return salario + reajuste;
    }

}

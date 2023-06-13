package com.testeunisomaweb.api.funcionario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO getFuncionarioPeloCpf(String cpf) {
        return this.getFuncionarioDTO(this.funcionarioRepository.findByCpf(cpf));
    }

    public List<FuncionarioDTO> getFuncionarios() {
        return this.getFuncionariosDTO(this.funcionarioRepository.findAll());
    }

    public FuncionarioDTO cadastrarFuncionario(FuncionarioEntity funcionario) {
        if (funcionario.getCpf().length() < 14) {
            String cpf = funcionario.getCpf();
            funcionario.setCpf(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
                    + cpf.substring(9));
        }
        return this.getFuncionarioDTO(this.funcionarioRepository.save(funcionario));
    }

    public void atualizarSalarioFuncionario(String cpf, double novoSalario) {
        FuncionarioEntity funcionario = this.funcionarioRepository.findByCpf(cpf);
        funcionario.setSalario(novoSalario);
        this.funcionarioRepository.save(funcionario);
    }

    private FuncionarioDTO getFuncionarioDTO(FuncionarioEntity funcionario) {
        return new FuncionarioDTO(funcionario.getNome(), funcionario.getCpf(), funcionario.getSalario());
    }

    private List<FuncionarioDTO> getFuncionariosDTO(List<FuncionarioEntity> funcionarios) {
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<FuncionarioDTO>();
        for (FuncionarioEntity funcionario : funcionarios) {
            funcionariosDTO
                    .add(new FuncionarioDTO(funcionario.getNome(), funcionario.getCpf(), funcionario.getSalario()));
        }
        return funcionariosDTO;
    }

}
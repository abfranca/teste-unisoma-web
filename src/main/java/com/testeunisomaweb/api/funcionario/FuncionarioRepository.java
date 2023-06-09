package com.testeunisomaweb.api.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    FuncionarioEntity findByCpf(String cpf);

}

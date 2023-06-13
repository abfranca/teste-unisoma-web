package com.testeunisomaweb.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.testeunisomaweb.api.financeiro.CalculoIRService;
import com.testeunisomaweb.api.financeiro.CalculoNovoSalarioService;
import com.testeunisomaweb.api.funcionario.FuncionarioDTO;
import com.testeunisomaweb.api.funcionario.FuncionarioService;

@ExtendWith(MockitoExtension.class)
public class TesteUniSomaWebApplicationTests {

	@Mock
	FuncionarioService funcionarioService;

	@InjectMocks
	CalculoNovoSalarioService calculoNovoSalarioService;

	@InjectMocks
	CalculoIRService calculoIRService;

	FuncionarioDTO funcionarioADto = new FuncionarioDTO("Ana Silva", "708.100.850-03",
			9876.54);
	FuncionarioDTO funcionarioBDto = new FuncionarioDTO("Pedro Silva", "822.471.090-47",
			1234.56);

	@Test
	public void testAtualizarSalario() {
		when(funcionarioService.getFuncionarioPeloCpf("708.100.850-03")).thenReturn(funcionarioADto);
		assertTrue("10271.60".equals(((Map<String, Object>) calculoNovoSalarioService.atualizarSalario("708.100.850-03")).get("Novo salario")));
		assertTrue("395.06".equals(((Map<String, Object>) calculoNovoSalarioService.atualizarSalario("708.100.850-03")).get("Reajuste ganho")));
		assertTrue("4 %".equals(((Map<String, Object>) calculoNovoSalarioService.atualizarSalario("708.100.850-03")).get("Em percentual")));
	}

	@Test
	public void testCalcularIR() {
		when(funcionarioService.getFuncionarioPeloCpf("708.100.850-03")).thenReturn(funcionarioADto);
		assertTrue("R$ 1955.43".equals(((Map<String, Object>) calculoIRService.calcularIR("708.100.850-03")).get("Imposto")));
	}

	@Test
	public void testCalcularIRIsento() {
		when(funcionarioService.getFuncionarioPeloCpf("822.471.090-47")).thenReturn(funcionarioBDto);
		assertTrue("Isento".equals(((Map<String, Object>) calculoIRService.calcularIR("822.471.090-47")).get("Imposto")));
	}

}

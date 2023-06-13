package com.testeunisomaweb.api.funcionario;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "O nome precisa ser preenchido.")
    @Size(min = 2, max = 50, message = "Nome precisa conter entre {min} e {max} caracteres.")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "O campo cpf precisa ser preenchido.")
    @CPF(message = "O cpf '${validatedValue}' é inválido.")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @NotNull(message = "O campo data precisa ser preenchido.")
    @Past(message = "A data '${validatedValue}' é inválida.")
    @Column(name = "nascimento")
    private LocalDate nascimento;

    @NotBlank(message = "O campo telefone precisa ser preenchido.")
    @Pattern(regexp = "^\\(\\d{2}\\)[\\s](?:9\\s\\d{4}|\\d{4})[-]\\d{4}$", message = "O telefone '${validatedValue}' é inválido.")
    @Column(name = "telefone")
    private String telefone;

    @NotBlank(message = "O endereço precisa ser preenchido.")
    @Size(min = 5, max = 50, message = "Endereço precisa conter entre {min} e {max} caracteres.")
    @Column(name = "endereco")
    private String endereco;

    @Min(0)
    @Column(name = "salario")
    private double salario;

    public FuncionarioEntity() {
    }

    public FuncionarioEntity(String nome, String cpf, LocalDate nascimento, String telefone, String endereco,
            double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
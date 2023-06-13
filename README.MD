## Descrição

Os requisitos funcionais e não funcionais da aplicação podem ser encontrados no arquivo [TesteUniSomaWeb.pdf](https://github.com/abfranca/teste-unisoma-web/blob/main/TesteUniSomaWeb.pdf)

## Pré-requisitos

[Maven](https://maven.apache.org/install.html) e [PostgreSQL](https://www.postgresqltutorial.com/postgresql-getting-started/).

## Configuração e build

Edite o arquivo [./src/main/resources/application.properties](https://github.com/abfranca/teste-unisoma-web/blob/main/src/main/resources/application.properties) com as configurações correspondentes ao seu database PostgreSQL.

Pelo terminal, execute o seguinte comando na raiz do projeto.

```bash
$ mvn package
```

## Executando o app

Pelo terminal, execute o seguinte comando na raiz do projeto.

```bash
$ java -jar .\target\api-0.0.1-SNAPSHOT.jar
```

## Endpoints

http://localhost:8080/api/funcionarios

O método HTTP GET retornará uma lista contendo o nome, o cpf e o salário dos funcionários cadastrados no banco de dados.

O método HTTP POST serve para cadastrar um novo funcionário e retornará o nome, o cpf e o salário do funcionário cadastrado.

```bash
# Padrão de envio da requisição
{
    "nome": "String de tamanho entre 2 e 50 caracteres",
    "cpf": "String contendo um cpf válido",
    "nascimento": "yyyy-MM-dd",
    "telefone": "(dd) d dddd-dddd | (dd) dddd-dddd",
    "endereco": "String de tamanho entre 5 e 50 caracteres",
    "salario": number maior ou igual a 0.0
}

# Exemplo
{
    "nome": "Ana Silva",
    "cpf": "708.100.850-03",
    "nascimento": "1990-01-01",
    "telefone": "(12) 9 3456-7890",
    "endereco": "Rua Bacaninha, 12",
    "salario": 9876.54
}

# Exemplo de retorno
{
    "nome": "Ana Silva",
    "cpf": "708.100.850-03",
    "salario": 9876.54
}
```

http://localhost:8080/api/funcionarios/atualizar_salario

O método HTTP POST serve para atualizar o salário de um funcionário e retornará o cpf, o novo salário, quanto foi o reajuste e a porcentagem desse reajuste para o funcionário informado.

```bash
# Padrão de envio da requisição
ddd.ddd.ddd-dd

# Exemplo
708.100.850-03

# Exemplo de retorno
{
    "Novo salario": "10271.60",
    "CPF": "708.100.850-03",
    "Reajuste ganho": "395.06",
    "Em percentual": "4 %"
}
```

http://localhost:8080/api/funcionarios/calcular_ir

O método HTTP POST serve para calcular o imposto de renda de um funcionário e retornará o cpf e o valor do imposto de renda correspondente para o funcionário informado, ou a string "Isento" caso ele não deva pagar imposto de renda.

```bash
# Padrão de envio da requisição
ddd.ddd.ddd-dd

# Exemplo
708.100.850-03

# Exemplo de retorno
{
    "CPF": "708.100.850-03",
    "Imposto": "R$ 2066.04"
}
```
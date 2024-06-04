# Projeto de Sistema de Gestão de Provas de Proficiência

Este projeto é um sistema de gestão de provas desenvolvido utilizando Spring Boot no backend e React com CoreUI no frontend. O sistema permite a criação, atualização, visualização e exclusão de provas, disciplinas, professores, questões e respostas. Além disso, possui funcionalidades para gerar e visualizar PDFs de provas, com questões embaralhadas.

## Entidades

### Professor

Representa um professor no sistema.

- **Campos:**
  - ```id```: Identificador único.
  - ```firstName```: Primeiro nome.
  - ```lastName```: Sobrenome.
  - ```name```: Nome completo.
  - ```email```: Email.
  - ```code```: Código único.
  - ```password```: Senha.
  - ```disciplines```: Lista de disciplinas associadas.
  - ```questions```: Lista de questões criadas.
  - ```answers```: Lista de respostas criadas.
  - ```exams```: Lista de provas criadas.

### Disciplina

Representa uma disciplina no sistema.

- **Campos:**
  - ```id```: Identificador único.
  - ```name```: Nome da disciplina.
  - ```code```: Código da disciplina.
  - ```description```: Descrição da disciplina.

### Questão

Representa uma questão de prova no sistema.

- **Campos:**
  - ```id```: Identificador único.
  - ```content```: Conteúdo da questão.
  - ```questionType```: Tipo da questão (múltipla escolha, dissertativa, etc.).
  - ```professor```: Professor que criou a questão.
  - ```images```: Lista de imagens associadas.
  - ```answers```: Lista de respostas associadas.
  - ```exams```: Lista de provas associadas.

### Resposta

Representa uma resposta de questão no sistema.

- **Campos:**
  - ```id```: Identificador único.
  - ```content```: Conteúdo da resposta.
  - ```isCorrect```: Indicador se a resposta está correta.
  - ```question```: Questão associada.
  - ```professor```: Professor que criou a resposta.
  - ```answerType```: Tipo da resposta.

### Prova

Representa uma prova no sistema.

- **Campos:**
  - ```id```: Identificador único.
  - ```title```: Título da prova.
  - ```professor```: Professor responsável pela prova.
  - ```discipline```: Disciplina associada.
  - ```questions```: Lista de questões da prova.

## Operações de Requisição

### Professor

- **GET /professors**: Recupera todos os professores.
- **GET /professor/{id}**: Recupera um professor pelo ID.
- **POST /professors**: Cria um novo professor.
- **PUT /professor/{id}**: Atualiza um professor existente.
- **PATCH /professor/{id}**: Atualiza parcialmente um professor.
- **DELETE /professor/{id}**: Exclui um professor.

### Disciplina

- **GET /disciplines**: Recupera todas as disciplinas.
- **GET /discipline/{id}**: Recupera uma disciplina pelo ID.
- **POST /disciplines**: Cria uma nova disciplina.
- **PUT /discipline/{id}**: Atualiza uma disciplina existente.
- **PATCH /discipline/{id}**: Atualiza parcialmente uma disciplina.
- **DELETE /discipline/{id}**: Exclui uma disciplina.

### Questão

- **GET /questions**: Recupera todas as questões.
- **GET /question/{id}**: Recupera uma questão pelo ID.
- **POST /questions**: Cria uma nova questão.
- **PUT /question/{id}**: Atualiza uma questão existente.
- **PATCH /question/{id}**: Atualiza parcialmente uma questão.
- **DELETE /question/{id}**: Exclui uma questão.

### Resposta

- **GET /answers**: Recupera todas as respostas.
- **GET /answer/{id}**: Recupera uma resposta pelo ID.
- **POST /answers**: Cria uma nova resposta.
- **PUT /answer/{id}**: Atualiza uma resposta existente.
- **PATCH /answer/{id}**: Atualiza parcialmente uma resposta.
- **DELETE /answer/{id}**: Exclui uma resposta.

### Prova

- **GET /exams**: Recupera todas as provas.
- **GET /exam/{id}**: Recupera uma prova pelo ID.
- **POST /exams**: Cria uma nova prova.
- **PUT /exam/{id}**: Atualiza uma prova existente.
- **PATCH /exam/{id}**: Atualiza parcialmente uma prova.
- **DELETE /exam/{id}**: Exclui uma prova.

## Funcionalidades do Sistema

- **CRUD Completo**: Operações de criação, leitura, atualização e exclusão para todas as entidades.
- **Geração de Provas**: Possibilidade de gerar provas com questões embaralhadas.
- **Visualização em PDF**: Visualização e download de provas em formato PDF.
- **Atualização em Tempo Real**: Visualização prévia das provas enquanto o usuário altera as seleções.

## Links de Referência

- [Spring Boot](https://spring.io/projects/spring-boot)
- [React](https://reactjs.org/)
- [CoreUI](https://coreui.io/react/)
- [React-PDF](https://github.com/diegomura/react-pdf)

---

**Nota**: Este projeto é um exemplo educacional para demonstrar a integração de um backend Spring Boot com um frontend React utilizando CoreUI e React-PDF para a renderização de PDFs. A funcionalidade e estrutura podem ser adaptadas conforme necessário para atender a requisitos específicos.

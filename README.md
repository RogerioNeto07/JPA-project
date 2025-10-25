Endpoints do projeto:
1. Livros

Buscar todos os livros disponíveis
GET http://localhost:8080/livros/disponiveis
Retorna todos os livros com quantidadeDisponivel > 0.

Buscar livros por categoria
GET http://localhost:8080/livros/categoria/{nomeCategoria}
Exemplo: http://localhost:8080/livros/categoria/Romance
Retorna todos os livros daquela categoria.

Buscar livros de um autor específico
GET http://localhost:8080/livros/autor/{nomeAutor}
Exemplo: http://localhost:8080/livros/autor/Machado%20de%20Assis
Retorna todos os livros escritos pelo autor, ordenados por ano de publicação.

2. Usuários

Buscar usuários por nome (busca parcial)
GET http://localhost:8080/usuarios/nome/{parteNome}
Exemplo: http://localhost:8080/usuarios/nome/Silva
Retorna todos os usuários cujo nome contém o parâmetro informado.

3. Empréstimos

Listar empréstimos ativos de um usuário
GET http://localhost:8080/emprestimos/ativos/{usuarioId}
Exemplo: http://localhost:8080/emprestimos/ativos/1
Retorna todos os empréstimos com status ATIVO de um usuário específico.

Listar empréstimos atrasados
GET http://localhost:8080/emprestimos/atrasados
Retorna todos os empréstimos com dataDevolucaoPrevista < data atual e status ATIVO.

4. Categorias

Contar quantidade de livros por categoria
GET http://localhost:8080/livros/estatisticas/categorias
Retorna uma lista com o nome da categoria e a quantidade de livros em cada uma, ordenada por quantidade decrescente.

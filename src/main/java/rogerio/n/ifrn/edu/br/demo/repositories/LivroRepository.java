package rogerio.n.ifrn.edu.br.demo.repositories;

import rogerio.n.ifrn.edu.br.demo.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE l.quantidadeDisponivel > 0 ORDER BY l.titulo ASC")
    List<Livro> findLivrosDisponiveis();

    @Query("SELECT l FROM Livro l WHERE l.categoria.nome = :nomeCategoria")
    List<Livro> findLivrosPorCategoria(@Param("nomeCategoria") String nomeCategoria);

    @Query("SELECT l FROM Livro l JOIN l.autores a " +
       "WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nomeAutor, '%')) " +
       "ORDER BY l.anoPublicacao ASC")
    List<Livro> findLivrosPorAutor(@Param("nomeAutor") String nomeAutor);

    @Query("SELECT l.categoria.nome, COUNT(l) " +
       "FROM Livro l GROUP BY l.categoria.nome " +
       "ORDER BY COUNT(l) DESC")
    List<Object[]> countLivrosPorCategoria();

}
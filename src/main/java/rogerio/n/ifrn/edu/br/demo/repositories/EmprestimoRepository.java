package rogerio.n.ifrn.edu.br.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rogerio.n.ifrn.edu.br.demo.models.Emprestimo;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("SELECT e FROM Emprestimo e " +
           "JOIN FETCH e.itens i " +
           "JOIN FETCH i.livro " +
           "WHERE e.usuario.id = :usuarioId AND e.status = 'ATIVO'")
    List<Emprestimo> findEmprestimosAtivosPorUsuario(@Param("usuarioId") Long usuarioId);

    @Query("SELECT e FROM Emprestimo e " +
            "JOIN FETCH e.usuario u " +
            "JOIN FETCH e.itens i " +
            "JOIN FETCH i.livro " +
            "WHERE e.dataDevolucaoPrevista < CURRENT_DATE " +
            "AND e.status = 'ATIVO'")
    List<Emprestimo> findEmprestimosAtrasados();

}

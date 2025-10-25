package rogerio.n.ifrn.edu.br.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rogerio.n.ifrn.edu.br.demo.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}

package rogerio.n.ifrn.edu.br.demo.controllers;
import rogerio.n.ifrn.edu.br.demo.models.Livro;
import rogerio.n.ifrn.edu.br.demo.repositories.LivroRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    @GetMapping("/disponiveis")
    public List<Livro> getLivrosDisponiveis() {
        return livroRepository.findLivrosDisponiveis();
    }
    @GetMapping("/categoria/{nome}")
    public List<Livro> getLivrosPorCategoria(@PathVariable String nome) {
        return livroRepository.findLivrosPorCategoria(nome);
    }
    @GetMapping("/autor/{nome}")
    public List<Livro> buscarPorAutor(@PathVariable String nome) {
        return livroRepository.findLivrosPorAutor(nome);
    }
    @GetMapping("/estatisticas/categorias")
    public List<Object[]> contarLivrosPorCategoria() {
        return livroRepository.countLivrosPorCategoria();
    }

}
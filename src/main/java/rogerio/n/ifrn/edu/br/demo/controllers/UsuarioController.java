package rogerio.n.ifrn.edu.br.demo.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import rogerio.n.ifrn.edu.br.demo.models.Usuario;
import rogerio.n.ifrn.edu.br.demo.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/buscar/{nome}")
    public List<Usuario> buscarPorNome(@PathVariable String nome) {
        return usuarioRepository.findByNomeParcial(nome);
    }
}

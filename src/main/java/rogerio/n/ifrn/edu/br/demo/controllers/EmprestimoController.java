package rogerio.n.ifrn.edu.br.demo.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import rogerio.n.ifrn.edu.br.demo.models.Emprestimo;
import rogerio.n.ifrn.edu.br.demo.repositories.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @GetMapping("/ativos/{usuarioId}")
    public List<Emprestimo> listarAtivos(@PathVariable Long usuarioId) {
        return emprestimoRepository.findEmprestimosAtivosPorUsuario(usuarioId);
    }

    @GetMapping("/atrasados")
    public List<Emprestimo> listarAtrasados() {
        return emprestimoRepository.findEmprestimosAtrasados();
}

}

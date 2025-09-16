package Avaliativos.Lista07.Biblioteca

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BibliotecaService {

    private final List<Livro> livrosDisponiveis = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public BibliotecaService() {
        // Inicializa com alguns livros
        livrosDisponiveis.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        livrosDisponiveis.add(new Livro("1984", "George Orwell"));
        livrosDisponiveis.add(new Livro("Dom Casmurro", "Machado de Assis"));
    }

    public List<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Optional<Emprestimo> criarEmprestimo(UUID livroId, String usuarioId) {
        Optional<Livro> livroOpt = livrosDisponiveis.stream()
                .filter(l -> l.getId().equals(livroId))
                .findFirst();

        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livrosDisponiveis.remove(livro);

            Emprestimo emprestimo = new Emprestimo(livro.getId(), usuarioId);
            emprestimos.add(emprestimo);
            return Optional.of(emprestimo);
        }

        return Optional.empty();
    }

    public Optional<Livro> devolverEmprestimo(UUID emprestimoId) {
        Optional<Emprestimo> emprestimoOpt = emprestimos.stream()
                .filter(e -> e.getEmprestimoId().equals(emprestimoId))
                .findFirst();

        if (emprestimoOpt.isPresent()) {
            Emprestimo emprestimo = emprestimoOpt.get();
            emprestimos.remove(emprestimo);

            // recria o livro devolvido (nesse caso não guardamos o título/autor original)
            Livro livro = new Livro("Livro devolvido", "Autor desconhecido");
            livro.setId(emprestimo.getLivroId()); // mantém o mesmo ID
            livrosDisponiveis.add(livro);

            return Optional.of(livro);
        }

        return Optional.empty();
    }
}

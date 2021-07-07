package pindorama.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pindorama.database.Conteudo;

import java.util.List;
import java.util.Optional;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

    Optional<Conteudo> findConteudoByNome(String nome);

    Conteudo findConteudoById(long id);

    List<Conteudo> findConteudoByMateria(int materia);
}

package pindorama.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pindorama.database.Materias;

import java.util.Optional;

public interface MateriasRepository extends JpaRepository<Materias, Long> {

    Optional<Materias> findMateriasById(long id);
}

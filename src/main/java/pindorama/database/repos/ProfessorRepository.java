package pindorama.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pindorama.database.Professor;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByName(String username);

    Professor findByEmail(String email);

    Professor findByEmailAndPassword(String email, String password);
}

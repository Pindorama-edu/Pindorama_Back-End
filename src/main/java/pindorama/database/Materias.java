package pindorama.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "materias")
@Data
public class Materias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "materia", nullable = false, unique = true)
    private String materia;

    public Materias(String materia){
        this.materia = materia;
    }

    public Materias() {
    }
}

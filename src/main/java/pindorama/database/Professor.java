package pindorama.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pindorama.utils.PasswordUtils;
import pindorama.utils.enums.Genero;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "professor")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "senha", nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "data_nascimento", nullable = false)
    private Date birthDate;

    @Column(name = "genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "avaliacao", nullable = false)
    private float avaliacao;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "status_conta", nullable = false)
    private int status;

    @Column(name = "foto", nullable = false)
    private byte[] picture;

    @JsonIgnore
    @Column(name = "mediatype")
    private String mediaType;

    public Professor(String name, String password, Date birthDate, Genero genero, String nacionalidade){
        this.name = name;
        this.password = PasswordUtils.getSalt(90);
        this.password = PasswordUtils.generateSecurePassword(password, salt);
        this.birthDate = birthDate;
        this.genero = genero;
        this.nacionalidade = nacionalidade;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    public Professor() {

    }
}

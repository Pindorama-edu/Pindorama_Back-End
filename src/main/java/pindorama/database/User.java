package pindorama.database;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pindorama.utils.PasswordUtils;
import pindorama.utils.enums.Genero;
import pindorama.utils.enums.UserType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "usuario")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "birthdate", nullable = false)
    private Date birthDate;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "data_criacao", nullable = false)
    private Date creationDate;

    @Column(name = "foto", nullable = true)
    private byte[] picture;

    @JsonIgnore
    @Column(name = "salt", nullable = false)
    private String salt;

    public User() {
    }

    public User(String username, String email, String password, Genero genero, String nacionalidade, Date birthDate) {
        this.username = username;
        this.email = email;
        this.salt = PasswordUtils.getSalt(70);
        this.password = PasswordUtils.generateSecurePassword(password, salt);
        ;
        this.genero = genero;
        this.userType = UserType.USER;
        this.nacionalidade = nacionalidade;
        this.birthDate = birthDate;
        this.creationDate = new Date(System.currentTimeMillis());
    }


}

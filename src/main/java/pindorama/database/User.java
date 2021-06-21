package pindorama.database;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table(value = "usuario")
@Data
public class User {

    @Id
    private long id;

    @Column("nome_usuario")
    private String username;

    @Column("email")
    private String email;

    @Column("senha")
    private String password;

    @Column("status_conta")
    private int status;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

package pindorama.database;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "conteudo")
@Data
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "professor", nullable = false)
    private int professor;

    @Column(name = "materia", nullable = false)
    private int materia;

    @Column(name = "palavras", nullable = false)
    private String palavras;

    @Column(name = "creationDate", updatable = false)
    private Date creationdate;

    @Column(name = "avaliacao", nullable = false)
    private float avaliacao;

    @Column(name = "status_conteudo", nullable = false)
    private int status_conteudo;

    @Column(name = "video", nullable = true)
    private String video;

    @Column(name = "mediaType", nullable = true)
    private String mediaType;

    public Conteudo(String nome, String descricao, int materia, int professor, String palavras, Date creationDate, String mediaType) {
        this.nome = nome;
        this.descricao = descricao;
        this.materia = materia;
        this.palavras = palavras;
        this.professor = professor;
        this.creationdate = creationDate;
        this.mediaType = mediaType;
    }

    public Conteudo() {

    }
}

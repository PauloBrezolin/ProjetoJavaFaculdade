package Dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Aulas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int sala;

    private String professor;

    @ManyToOne
    private Horarios horario;

    @ManyToOne
    private Dias dia;

    public Aulas(){
    }

    public Aulas(String professor, int sala, Horarios horario, Dias dia) {
        this.sala = sala;
        this.professor = professor;
        this.horario = horario;
        this.dia = dia;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario) {
        this.horario = horario;
    }

    public Dias getDia() {
        return dia;
    }

    public void setDia(Dias dia) {
        this.dia = dia;
    }
    
}

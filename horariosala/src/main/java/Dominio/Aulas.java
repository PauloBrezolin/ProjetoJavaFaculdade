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

    private String professor;

    private int sala;

    private int dia;

    private int turno;

    public Aulas() {
    }

    public Aulas(String professor, int sala, int turno, int dia) {
        this.sala = sala;
        this.professor = professor;
        this.turno = turno;
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

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

}

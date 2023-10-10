package Dominio;

import java.sql.Time;
import javax.persistence.*;

@Entity
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int turno;

    @ManyToOne
    private Dias dia;

    public Horarios() {
    }

    public Horarios(int turno, Time inicio, Time fim, Dias dia) {
        this.turno = turno;
        this.dia = dia;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Dias getDia() {
        return dia;
    }

    public void setDia(Dias dia) {
        this.dia = dia;
    }
}
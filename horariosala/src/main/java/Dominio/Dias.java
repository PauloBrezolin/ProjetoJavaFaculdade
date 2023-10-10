package Dominio;

import javax.persistence.*;

@Entity
public class Dias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dia;

    public Dias() {
    }

    public Dias(int dia) {
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    
}

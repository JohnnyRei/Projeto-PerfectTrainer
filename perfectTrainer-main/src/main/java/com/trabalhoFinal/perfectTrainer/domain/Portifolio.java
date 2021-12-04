package com.trabalhoFinal.perfectTrainer.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Portifolio")
@Table(name = "Portifolio")
public class Portifolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Personal personal;
    @ManyToOne(cascade = CascadeType.ALL)
    private TreinoCasa treinoCasa;
    @ManyToOne(cascade = CascadeType.ALL)
    private TreinoAcademia treinoAcademia;

    public Portifolio() {}

    public Portifolio(Long id, Personal personal, TreinoCasa treinoCasa, TreinoAcademia treinoAcademia) {
        this.id = id;
        this.personal = personal;
        this.treinoCasa = treinoCasa;
        this.treinoAcademia = treinoAcademia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public TreinoCasa getTreinoCasa() {
        return treinoCasa;
    }

    public void setTreinoCasa(TreinoCasa treinoCasa) {
        this.treinoCasa = treinoCasa;
    }

    public TreinoAcademia getTreinoAcademia() {
        return treinoAcademia;
    }

    public void setTreinoAcademia(TreinoAcademia treinoAcademia) {
        this.treinoAcademia = treinoAcademia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portifolio that = (Portifolio) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Portifolio{" +
                "id=" + id +
                ", personal=" + personal +
                ", treinoCasa=" + treinoCasa +
                ", treinoAcademia=" + treinoAcademia +
                '}';
    }
}

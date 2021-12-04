package com.trabalhoFinal.perfectTrainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "TreinoAcademia")
@Table(name = "TreinoAcademia")
public class TreinoAcademia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String academia;
    private String tipo;
    @ManyToOne(cascade = CascadeType.ALL)
    private Personal personal;
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public TreinoAcademia() {}

    public TreinoAcademia(Long id, Date data, String academia, String tipo, Personal personal, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.academia = academia;
        this.tipo = tipo;
        this.personal = personal;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreinoAcademia that = (TreinoAcademia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TreinoAcademia{" +
                "id=" + id +
                ", data=" + data +
                ", academia='" + academia + '\'' +
                ", tipo='" + tipo + '\'' +
                ", personal=" + personal +
                ", usuario=" + usuario +
                '}';
    }
}

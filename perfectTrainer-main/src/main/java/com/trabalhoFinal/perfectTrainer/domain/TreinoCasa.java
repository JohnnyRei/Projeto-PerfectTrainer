package com.trabalhoFinal.perfectTrainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "TreinoCasa")
@Table(name = "TreinoCasa")
public class TreinoCasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    @ManyToOne(cascade = CascadeType.ALL)
    private Personal personal;
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    private String endereco;
    private String tipo;

    public TreinoCasa() {}

    public TreinoCasa(Long id, Date data, Personal personal, Usuario usuario, String endereco, String tipo) {
        this.id = id;
        this.data = data;
        this.personal = personal;
        this.usuario = usuario;
        this.endereco = endereco;
        this.tipo = tipo;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreinoCasa that = (TreinoCasa) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TreinoCasa{" +
                "idTreinoCasa=" + id +
                ", data=" + data +
                ", personal=" + personal +
                ", usuario=" + usuario +
                ", endereco='" + endereco + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

package br.com.alura.screensound.model;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne
    private Artista artista;

    public Musica(){}
    public Musica(String nome){
        this.titulo = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public Artista getArtista(){
        return artista;
    }

    public void setArtista(Artista artista){
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Música='" + titulo + '\'' +
                ", artista=" + artista.getNome();
    }
}

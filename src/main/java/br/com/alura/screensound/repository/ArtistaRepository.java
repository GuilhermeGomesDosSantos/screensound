package br.com.alura.screensound.repository;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

//    List<Artista> findAll();
    @Query("SELECT a FROM Artista a ORDER BY a.nome ASC")
    List<Artista> mostrarArtistas();

    Optional<Artista> findByNomeContainingIgnoreCase(String artistaEscolhido);

    @Query("SELECT m FROM Musica m ORDER BY m.titulo ASC")
    List<Musica> listarMusicas();

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musica> musicaArtista(String nome);
}

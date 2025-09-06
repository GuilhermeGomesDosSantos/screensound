package br.com.alura.screensound.Principal;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;

import java.util.*;

public class Principal {

    private final ArtistaRepository repository;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void exibirMenu() {
        var opcao = 0;

        while (opcao != 9){
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista
                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtistas();
                    break;
                case 5:
                    pesquisarSobreArtista();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        }
    }

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";
        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Informe o nome desse artista: ");
            var nomeArtista = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla ou banda: ");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());

            Artista artista = new Artista(nomeArtista, tipoArtista);
            repository.save(artista);

            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }
    }

    private void cadastrarMusicas() {
        List<Artista> artistas = repository.mostrarArtistas();
        System.out.println("***** Artistas *****");
        artistas.forEach(a -> System.out.println(a.getNome()));

        System.out.println("Escolha um artista para cadastrar a musica: ");
        var artistaEscolhido = leitura.nextLine();
        Optional<Artista> artista = repository.findByNomeContainingIgnoreCase(artistaEscolhido);

        if(artista.isPresent()){
            System.out.println("Digite o nome da Música: ");
            var nomeMusica = leitura.nextLine();
            Musica music = new Musica(nomeMusica);
            music.setArtista(artista.get());
            artista.get().getMusicas().add(music);
            repository.save(artista.get());

            System.out.println("Música '" + nomeMusica + "' gravada para o Artista " + artista);
        } else {
            System.out.println("Artista não encontrado");
        }

    }

    private void listarMusicas(){
        List<Musica> musicas = repository.listarMusicas();
        musicas.forEach(m -> System.out.println("Música: " + m.getTitulo() + " - Artista: " + m.getArtista().getNome()));
    }
    private void buscarMusicasPorArtistas(){
        System.out.println("***** Artistas *****");
        List<Artista> artistas = repository.mostrarArtistas();
        artistas.forEach(artista -> System.out.println(artista.getNome()));

        System.out.println("Escolha um artista para lista a(s) Música(s)");
        var nome = leitura.nextLine();

        List<Musica> musicas = repository.musicaArtista(nome);
        musicas.forEach(m -> System.out.println(m.getArtista().getNome() + " - Música: " + m.getTitulo()));

    }

    private void pesquisarSobreArtista(){

    }
}

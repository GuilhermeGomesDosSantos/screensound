package br.com.alura.screensound.Principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    public void exibeMenu() {


        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    *** Screen Sound Músicas ***
                    
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar música por artistas
                    5 - Pesquisar dados sobre um artista
                    
                    9 - Sair
                    """;

            System.out.println(menu);

            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMuscias();
                    break;
                case 3:
                    listarMusicas();
                case 4:
                    buscarMusicasPorArtista();
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    private void pesquisarDadosDoArtista() {
    }

    private void buscarMusicasPorArtista() {
    }

    private void listarMusicas() {
    }

    private void cadastrarMuscias() {
    }

    private void cadastrarArtista() {
    }
}

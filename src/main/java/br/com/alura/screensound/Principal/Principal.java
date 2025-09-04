package br.com.alura.screensound.Principal;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
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
    }

    private void cadastrarMusicas() {

    }

    private void listarMusicas(){

    }
    private void buscarMusicasPorArtistas(){

    }

    private void pesquisarSobreArtista(){

    }
}

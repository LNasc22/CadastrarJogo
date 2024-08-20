package br.pucpr.lucassilva29.game_registration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {

    static Scanner input=new Scanner(System.in);

    public static void menu(){

        List<Game> games=new ArrayList<>();

        while (true){
            System.out.println("*** Cadastramento de jogo ***");
            System.out.println("1. Registrar seu jogo");
            System.out.println("2. Editar dados do jogo");
            System.out.println("3. Excluir jogo");
            System.out.println("4. Listar jogos");
            System.out.println("5. Limpar lista de jogos");
            System.out.println("6. Sair\n");
            System.out.print("Digite a opção que deseja: ");

            int option=input.nextInt();
            switch (option){
                case 1:
                    if (add_game(games)) {
                        System.out.println("Jogo registrado com sucesso!\n");
                    }
                    else {
                        System.out.println("Problemas ao registrar jogo.\n");
                    }
                    break;
                case 2:
                    if (edit_game(games)){
                        System.out.println("Jogo esditado com sucesso!\n");
                    }
                    else{
                        System.out.println("Problemas ao editar jogo.\n");
                    }
                    break;
                case 3:
                    if (del_game(games)) {
                        System.out.println("Jogo excluído com sucesso!\n");
                    }
                    else {
                        System.out.println("O jogo digitado não está registrado.\n");
                    }
                    break;
                case 4:
                    list_data(games);
                    break;
                case 5:
                    clean_data(games);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static boolean add_game(List<Game> games){

        System.out.println("AVISO: Digite os nomes sem espaços ou usando underline.");
        System.out.print("Digite o nome do jogo: ");
        String name= input.next();
        Game findGame=find_game(games, name);
        if (findGame != null){

            System.out.println("Jogo já registrado: "+findGame.name+"\n");
            return false;
        }
        System.out.print("Digite o gênero do jogo: ");
        String genre= input.next();
        System.out.print("Digite o ano de publicação do jogo: ");
        int year= input.nextInt();
        System.out.print("Digite o estúdio reponsável pelo jogo: ");
        String studio= input.next();
        System.out.print("Digite a plataforma principal do jogo: ");
        String platform= input.next();
        System.out.print("Digite o engine em que o jogo foi feito: ");
        String engine= input.next();

        Game game=new Game();
        game.name=name;
        game.genre=genre;
        game.year=year;
        game.studio=studio;
        game.platform=platform;
        game.engine=engine;

        return games.add(game);
    }

    public static Game find_game(List<Game> games, String name){

        for (Game game:games){

            if (game.name.equalsIgnoreCase(name)){

                return game;
            }
        }

        return null;
    }

    public static boolean edit_game(List<Game> games){

        System.out.print("Digite o nome do jogo que deseja editar: ");
        String nome= input.next();

        for (Game game:games){
            if (game.name.equalsIgnoreCase(nome)){
                System.out.print("Digite um novo nome: ");
                String nome2= input.next();
                game.name=nome2;
                System.out.print("Digite um novo gênero: ");
                String genre2= input.next();
                game.genre=genre2;
                System.out.print("Digite um novo ano: ");
                int year2= input.nextInt();
                game.year=year2;
                System.out.print("Digite um novo estúdio: ");
                String studio2= input.next();
                game.studio=studio2;
                System.out.print("Digite uma nova plataforma: ");
                String platform2= input.next();
                game.platform=platform2;
                System.out.print("Digite uma nova engine: ");
                String engine2=input.next();
                game.engine=engine2;
                break;
                }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean del_game(List<Game> games){

        System.out.print("Digite o nome do jogo que deseja excluir: ");
        String nome= input.next();

        Game g = null;

        for (Game game:games){
            if (game.name.equalsIgnoreCase(nome)){
                g=game;
                break;
            }
            else{
                return false;
            }
        }
        if (g != null){
            games.remove(g);
        }
        return true;
    }

    public static void list_data(List<Game> games){

        System.out.println("*** Listando jogos ***");
        for (Game game:games){

            System.out.println("Jogo: "+game.name+" ("+game.year+") - Gênero: "+game.genre+" - Estúdio: "
                    +game.studio+" - Plataforma: "+game.platform+" - Engine: "+game.engine);
        }
        System.out.println("*** Fim da listagem ***\n");
    }

    public static void clean_data(List<Game> games){

        games.clear();
        System.out.println("Lista de jogos limpa com sucesso!\n");
    }

    public static void main(String[] args){

        menu();
    }
}

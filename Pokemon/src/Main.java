import model.*;
import service.GameService;
import service.LoadService;
import service.PlayerService;
import service.WeatherService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        WeatherService weatherService = new WeatherService();
        GameService gameService = new GameService();
        int currentRound = 0;
        int maxRound = 2;
        boolean isGameFinished = true;

        ArrayList<model.Character> characterList = loadService.loadCharacters();
        System.out.println("--------Characters----------");
        for (model.Character character : characterList) {
            System.out.println(character.toString());
        }
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();

        System.out.println("Pokemon Game Hoşgeldiniz");
        System.out.print("Oyuna başlamak için 1, çıkmak için 2'yi tuşlayınız :");
        int choose = inp.nextInt();

        if (choose == 1) {

            Player player1 = gameService.addNewUser(characterList, pokemonList);
            pokemonList.remove(player1.getCharacter().getPokemonList().get(0)); // pokemon seçildikçe listedn cıkarılıp aynı pokemonun seçilmemesi için.
            Player player2 = gameService.addNewUser(characterList, pokemonList);
            pokemonList.remove(player2.getCharacter().getPokemonList().get(0));
            pokemonList.remove(player1.getCharacter().getPokemonList().get(0)); // pokemon seçildikçe listedn cıkarılıp aynı pokemonun seçilmemesi için.

            Random random = new Random();
            boolean isPlayer1Fight = random.nextBoolean();

            while (true) {
                if (gameService.checkHealth(player1) && gameService.checkHealth(player2)) {
                    WeatherEnum weatherEnum = weatherService.getRandomWeather();
                    weatherService.applyWeatherImpact(player1, player2, weatherEnum);
                    System.out.println("HAVA DURUMU : " + weatherEnum);
                    if (isPlayer1Fight) {
                        System.out.println("Player 1(" + player1.getName() + ")'in sırası:");
                        gameService.attackOptions(player1, player2);
                        isPlayer1Fight = false;
                    } else {
                        System.out.println("Player 2(" + player2.getName() + ")'in sırası:");
                        gameService.attackOptions(player2, player1);
                        isPlayer1Fight = true;
                    }
                } else {
                    currentRound += 1;
                    if (currentRound == 1) {
                        System.out.println("------------------------------------");
                        System.out.println("2.TUR BASLIYOR(Devam etmek için 1, Oyundan çıkmak için 2'ye basınız.)");
                        if(inp.nextInt() == 2) {
                            break;
                        }
                        System.out.println("------------------------------------");
                    }
                    if (!gameService.checkHealth(player1) && gameService.checkHealth(player2)) {
                        //player 1 kaybetti
                        System.out.println(player1.getName() + " oyunu kaybetti.");
                        if (currentRound == maxRound) {
                            System.out.println("Oyun bitti.");
                            break;
                        }
                        gameService.makeChangesEndOfTheRound(player2, player1, pokemonList);
                    } else if (gameService.checkHealth(player1) && !gameService.checkHealth(player2)) {
                        //player 2 kaybetti
                        System.out.println(player2.getName() + " oyunu kaybetti.");
                        if (currentRound == maxRound) {
                            System.out.println("Oyun bitti.");
                            break;
                        }
                        gameService.makeChangesEndOfTheRound(player1, player2, pokemonList);
                    }
                }
            }
        } else if (choose == 2) {
            return;
        }

    }
}
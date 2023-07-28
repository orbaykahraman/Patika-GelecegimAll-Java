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

        ArrayList<model.Character> characterList = loadService.loadCharacters();
        System.out.println("--------Characters----------");
        for (model.Character character : characterList){
            System.out.println(character.toString());
        }

        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();

        System.out.println("Pokemon Game Hoşgeldiniz");
        System.out.print("Oyuna başlamak için 1, çıkmak için 2'yi tuşlayınız :");
        int choose = inp.nextInt();

        if (choose == 1 ){
                for (int j = 0; j < characterList.size(); j++){
                    System.out.println((j + 1) + "." + characterList.get(j).getName());
                }
                System.out.print("Karekterinizi seçiniz :");
                int characterChoose = inp.nextInt();

                System.out.print("İsminizi giriniz :");
                String playerName = inp.next();

                Player player1 = playerService.createPlayer(playerName, characterList.get(characterChoose - 1));

                for (int k = 0; k < pokemonList.size(); k++){
                    System.out.println((k+1)+ "." + pokemonList.get(k));
                }
                System.out.print("Lütfen oynamak istediğiniz pokemonu seçiniz :");
                int pokemonChoose = inp.nextInt();

                player1.getCharacter().getPokemonList().add(pokemonList.get(pokemonChoose-1));

                pokemonList.remove(player1.getCharacter().getPokemonList().get(0)); // pokemon seçildikçe listedn cıkarılıp aynı pokemonun seçilmemesi için.

            for (int j = 0; j < characterList.size(); j++){
                System.out.println((j + 1) + "." + characterList.get(j).getName());
            }
            System.out.print("Karekterinizi seçiniz :");
            int characterChoose2 = inp.nextInt();

            System.out.print("İsminizi giriniz :");
            String playerName2 = inp.next();

            Player player2 = playerService.createPlayer(playerName2, characterList.get(characterChoose2 - 1));

            for (int k = 0; k < pokemonList.size(); k++){
                System.out.println((k+1)+ "." + pokemonList.get(k));
            }
            System.out.print("Lütfen oynamak istediğiniz pokemonu seçiniz :");
            int pokemonChoose2 = inp.nextInt();

            player2.getCharacter().getPokemonList().add(pokemonList.get(pokemonChoose2-1));
            pokemonList.remove(player1.getCharacter().getPokemonList().get(0)); // pokemon seçildikçe listedn cıkarılıp aynı pokemonun seçilmemesi için.
            Random random = new Random();
            boolean isPlayer1Fight = random.nextBoolean();

            while(true) {
                WeatherForecast weatherForecast = weatherService.getRandomWeather();
                weatherService.applyWeatherImpact(player1,player2,weatherForecast);
                System.out.println("HAVA DURUMU : " + weatherForecast);
                System.out.println(player1.getCharacter().getPokemonList().get(0));
                System.out.println(player2.getCharacter().getPokemonList().get(0));
                    if(gameService.checkHealth(player1) && gameService.checkHealth(player2)) {
                        if(isPlayer1Fight) {
                            System.out.println("Player 1(" + player1.getName() + ")'in sırası:");
                            gameService.attackOptions(player1,player2);
                            isPlayer1Fight = false;
                        }
                        else {
                            System.out.println("Player 2(" + player2.getName() + ")'in sırası:");
                            gameService.attackOptions(player2,player1);
                            isPlayer1Fight = true;
                        }
                    }
                    else {
                        currentRound += 1;
                        if (currentRound == 1) {
                            System.out.println("------------------------------------");
                            System.out.println("2.TUR BASLIYOR");
                            System.out.println("------------------------------------");
                        }
                        if(currentRound == maxRound) {
                            System.out.println("Oyun bitti.");
                            break;
                        }
                         if(!gameService.checkHealth(player1) && gameService.checkHealth(player2)){
                            //player 1 kaybetti
                            gameService.makeChangesEndOfTheRound(player2,player1,pokemonList);
                        }
                         else if(gameService.checkHealth(player1) && !gameService.checkHealth(player2)) {
                            //player 2 kaybetti
                            gameService.makeChangesEndOfTheRound(player1,player2,pokemonList);
                        }

                    }
            }
        }




    }
}
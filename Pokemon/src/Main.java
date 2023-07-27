import model.Character;
import model.Player;
import model.Pokemon;
import model.SpecialPower;
import service.LoadService;
import service.PlayerService;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();

        ArrayList<model.Character> characterList = loadService.loadCharacters();
        System.out.println("--------Characters----------");
        for (model.Character character : characterList){
            System.out.println(character.toString());
        }

        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();



        SpecialPower specialPower = new SpecialPower("as",10,10);
        Character c = new Character("MEHMET", specialPower,pokemonList);
        playerService.createPlayer("Orbay", c);
    }
}
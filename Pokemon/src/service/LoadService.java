package service;

import model.*;
import model.Character;

import java.util.ArrayList;

public class LoadService {
    public ArrayList<Character> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);

        Character ash = new Ash("Ash", strategy1, null);
        Character brooke = new Brooke("Brooke", strategy2, null);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricity = new Electricty("Electricty", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu("Pikachu", 100, 10, TypeEnum.ELECTRICY, electricity);
        Pokemon pokemon2 = new Sqiurtle("Squirtle", 120, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmender", 90, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar("Balbausar", 140, 7, TypeEnum.EARTH, earth);
        Pokemon pokemon5 = new Balbausar("Ivysaur", 145, 8, TypeEnum.GRASS, new SpecialPower("Grass",2,3));
        Pokemon pokemon6 = new Balbausar("Pidgeotto", 95, 11, TypeEnum.AIR, new SpecialPower("Air",6,3));

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);
        pokemonList.add(pokemon5);
        pokemonList.add(pokemon6);

        return pokemonList;
    }

    public Pokemon getWeakestPokemon(ArrayList<Pokemon> pokemonList) {
        Pokemon weakestPokemon = null;
        int max = Integer.MAX_VALUE;
        for(Pokemon p : pokemonList) {
            if(p.getDamage() < max) {
                weakestPokemon = p;
            }
        }
        return weakestPokemon;
    }

    public int getPokemonBaseDamage(String pokemonName) {
        if(pokemonName.equalsIgnoreCase("Pikachu")) {
            return 10;
        }
        else if(pokemonName.equalsIgnoreCase("Squirtle")) {
            return 8;
        }
        else if(pokemonName.equalsIgnoreCase("Charmender")) {
            return 12;
        }
        else if(pokemonName.equalsIgnoreCase("Balbausar")) {
            return 7;
        }
        else if(pokemonName.equalsIgnoreCase("Iyvsaur")) {
            return 8;
        }
        else if(pokemonName.equalsIgnoreCase("Pidgeotto")) {
            return 11;
        }
        else {
            return 0;
        }
    }

}

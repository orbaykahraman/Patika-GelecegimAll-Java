package service;

import model.Player;
import model.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameService {

    Scanner scanner = new Scanner(System.in);
    LoadService loadService = new LoadService();

    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);

        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainingRights();

        int damage = 0;
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
            } else if (isPokeSpecialAttack) {
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                damage = 0;
            } else {
                damage += attackingPokemon.getDamage();
            }
        }

        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
    }

    public boolean checkHealth(Player player) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);

        if(pokemon.getHealth() > 0 ) {
            return true;
        }
        else {
            return false;
        }
    }

    public void attackOptions(Player attacker,Player defender) {
        Pokemon pokemonOfAttacker = attacker.getCharacter().getPokemonList().get(0);
        Pokemon pokemonOfDefender = defender.getCharacter().getPokemonList().get(0);
        System.out.print("Saldırı türünü seçiniz : \n" + "1-Normal Saldırı \n" +
                "2-Pokemon Özel Saldırı(Kalan hakkınız : "+ pokemonOfAttacker.getSpecialPower().getRemainingRights() + ")\n" +
                "3-Karakter Özel Saldırı(Kalan hakkınız : "+ attacker.getCharacter().getSpecialPower().getRemainingRights() + ")\n");

        int chooseOfAttack = scanner.nextInt();

        if(chooseOfAttack == 1) {
            attack(attacker,defender,false,false);
        }
        else if(chooseOfAttack == 2) {
            attack(attacker,defender,true,false);
        }
        else if(chooseOfAttack == 3) {
            attack(attacker,defender,false,true);
        }
        else {
            System.out.println("Yanlis bir numara sectiniz.");
        }
        System.out.println("Atak sonrası pokemonların kalan canları : ");
        System.out.print(attacker.getCharacter().getName() + " adlı oyuncunun pokemonu " + pokemonOfAttacker.getName() + " 'ın canı : " + pokemonOfAttacker.getHealth());
        System.out.print(defender.getCharacter().getName() + " adlı oyuncunun pokemonu " + pokemonOfDefender.getName() + " 'ın canı : " + pokemonOfDefender.getHealth());
    }


    public void askWinnerToChoosePokemon(Player player) {
        List<Pokemon> pokemonList = player.getCharacter().getPokemonList();

        for (int k = 0; k < pokemonList.size(); k++){
            System.out.println((k+1)+ "." + pokemonList.get(k));
        }
        System.out.print("Lütfen oynamak istediğiniz pokemonu seçiniz :");
        int pokemonChooseOfWinner = scanner.nextInt();

        if(pokemonChooseOfWinner != 1) {
            Pokemon pokemon = pokemonList.get(0);
            pokemonList.set(0,pokemonList.get(pokemonChooseOfWinner-1));
            pokemonList.remove(pokemonChooseOfWinner-1);
            pokemonList.add(pokemon);
        }
    }

    public void makeChangesEndOfTheRound(Player winner, Player loser, ArrayList<Pokemon> pokemonList) {
        System.out.println(loser.getName() + " oyunu kaybetti.");
        winner.getCharacter().getPokemonList().add(loser.getCharacter().getPokemonList().get(0));
        winner.getCharacter().getPokemonList().get(1).setHealth(100);
        loser.getCharacter().getPokemonList().remove(0);
        loser.getCharacter().getPokemonList().add(loadService.getWeakestPokemon(pokemonList));
        askWinnerToChoosePokemon(winner);
    }
}

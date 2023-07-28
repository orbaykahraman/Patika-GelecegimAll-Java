package service;

import model.Character;
import model.Player;
import model.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameService {

    Scanner scanner = new Scanner(System.in);
    LoadService loadService = new LoadService();

    PlayerService playerService = new PlayerService();

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
        System.out.println(attacker.getName() + " adlı oyuncunun pokemonu " + pokemonOfAttacker.getName() + "'ın canı : " + pokemonOfAttacker.getHealth());
        System.out.println(defender.getName() + " adlı oyuncunun pokemonu " + pokemonOfDefender.getName() + "'ın canı : " + pokemonOfDefender.getHealth());
        System.out.println("------------------------------");
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
        pokemonList.get(0).getSpecialPower().setRemainingRights(3);
    }

    public void makeChangesEndOfTheRound(Player winner, Player loser, ArrayList<Pokemon> pokemonList) {
        ArrayList<Pokemon> winnerPokemonList = winner.getCharacter().getPokemonList();
        ArrayList<Pokemon> loserPokemonList = loser.getCharacter().getPokemonList();

        winnerPokemonList.add(loser.getCharacter().getPokemonList().get(0));
        winnerPokemonList.get(1).setHealth(100);
        winnerPokemonList.get(1).setDamage(loadService.getPokemonBaseDamage(winnerPokemonList.get(1).getName()));
        loserPokemonList.remove(0);
        loserPokemonList.add(loadService.getWeakestPokemon(pokemonList));

        winner.getCharacter().setPokemonList(winnerPokemonList);
        loser.getCharacter().setPokemonList(loserPokemonList);

        winner.getCharacter().getSpecialPower().setRemainingRights(1);
        loser.getCharacter().getSpecialPower().setRemainingRights(1);
        askWinnerToChoosePokemon(winner);
    }

    public Player addNewUser(ArrayList<Character> characterList, ArrayList<Pokemon> pokemonList) {
        for (int j = 0; j < characterList.size(); j++){
            System.out.println((j + 1) + "." + characterList.get(j).getName());
        }
        System.out.print("Karekterinizi seçiniz :");
        int characterChoose = scanner.nextInt();

        System.out.print("İsminizi giriniz :");
        String playerName = scanner.next();

        Player player = playerService.createPlayer(playerName, characterList.get(characterChoose - 1));

        for (int k = 0; k < pokemonList.size(); k++){
            System.out.println((k+1)+ "." + pokemonList.get(k));
        }
        System.out.print("Lütfen oynamak istediğiniz pokemonu seçiniz :");
        int pokemonChoose = scanner.nextInt();

        player.getCharacter().getPokemonList().add(pokemonList.get(pokemonChoose-1));

        return player;
    }

}

package service;

import model.Player;
import model.Pokemon;

import java.util.Scanner;

public class GameService {

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
            System.out.println(player.getName() + " oyunu kaybetti.");
            return false;
        }
    }

    public void attackOptions(Player attacker,Player defender) {
        System.out.print("Saldırı türünü seçiniz : \n" + "1-Normal Saldırı \n" + "2-Pokemon Özel Saldırı \n" + "3-Karakter Özel Saldırı \n");
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("You choose wrong number.");
        }

    }



}

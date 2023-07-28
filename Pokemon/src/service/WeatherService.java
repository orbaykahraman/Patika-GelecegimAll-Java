package service;

import model.Player;
import model.Pokemon;
import model.TypeEnum;
import model.WeatherEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherService {

    Random random = new Random();

    public WeatherEnum getRandomWeather() {
        List<WeatherEnum> weatherEnumList = new ArrayList<>();
        for (WeatherEnum weatherEnum : WeatherEnum.values()){
            weatherEnumList.add(weatherEnum);
        }

        int randomNumber = random.nextInt(weatherEnumList.size());

        return weatherEnumList.get(randomNumber);
    }

    public void weatherImpact(WeatherEnum weatherEnum, Pokemon pokemon) {
        if (weatherEnum == WeatherEnum.SUN) {
            if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() + 6);
                System.out.println("Güneşli havada Ateş gücü 2 katına çıktı");
            } else if (pokemon.getType() == TypeEnum.WATER) {
                pokemon.setDamage(pokemon.getDamage() -5);
            } else if(pokemon.getType() == TypeEnum.AIR) {
                pokemon.setDamage(pokemon.getDamage() + 6);
            }

        }
        if (weatherEnum == WeatherEnum.RAIN) {
            if (pokemon.getType() == TypeEnum.WATER) {
                pokemon.setDamage(pokemon.getDamage() +6);
            } else if (pokemon.getType() == TypeEnum.ELECTRICY) {
                pokemon.setDamage(pokemon.getDamage() + 6);
            } else if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() - 5);
            }
        }

        if (weatherEnum == WeatherEnum.WIND) {
            if (pokemon.getType() == TypeEnum.EARTH) {
                pokemon.setDamage(pokemon.getDamage() +6);
            } else if (pokemon.getType() == TypeEnum.GRASS) {
                pokemon.setDamage(pokemon.getDamage() +6);
            } else if (pokemon.getType() == TypeEnum.ELECTRICY) {
                pokemon.setDamage(pokemon.getDamage() -5);
            }
        }
        if(weatherEnum == WeatherEnum.CLOUD) {
            if(pokemon.getType() == TypeEnum.AIR) {
                pokemon.setDamage(pokemon.getDamage() + 6);
            }
            else if(pokemon.getType() == TypeEnum.GRASS) {
                pokemon.setDamage(pokemon.getDamage() - 5);
            }
        }
    }
    public void applyWeatherImpact(Player player1, Player player2, WeatherEnum weatherEnum){
        for(Pokemon p : player1.getCharacter().getPokemonList()) {
            weatherImpact(weatherEnum,p);
        }
        for(Pokemon p : player2.getCharacter().getPokemonList()) {
            weatherImpact(weatherEnum,p);
        }
    }


}

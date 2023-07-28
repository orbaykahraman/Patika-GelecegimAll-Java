package service;

import model.Player;
import model.Pokemon;
import model.TypeEnum;
import model.WeatherForecast;

import java.util.ArrayList;
import java.util.List;

public class WeatherService {

    public WeatherForecast getRandomWeather() {
        List<WeatherForecast> weatherForecastList = new ArrayList<>();
        for (WeatherForecast weatherForecast : WeatherForecast.values()){
            weatherForecastList.add(weatherForecast);
        }

        int max = weatherForecastList.size() - 1;
        int min = 0;

        int randomNumber = (int) (Math.random() * ( max - min) + 1);

        return weatherForecastList.get(randomNumber);
    }

    public void weatherImpact(WeatherForecast weatherForecast, Pokemon pokemon) {
        if (weatherForecast == WeatherForecast.SUN) {
            if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() + 5);
                System.out.println("Güneşli havada Ateş gücü 2 katına çıktı");
            } else if (pokemon.getType() == TypeEnum.WATER) {
                pokemon.setDamage(pokemon.getDamage() -5);
            }

        }
        if (weatherForecast == WeatherForecast.RAIN) {
            if (pokemon.getType() == TypeEnum.WATER) {
                pokemon.setDamage(pokemon.getDamage() +5);
            } else if (pokemon.getType() == TypeEnum.ELECTRICY) {
                pokemon.setDamage(pokemon.getDamage() +4);
            } else if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() - 5);
            }
        }

        if (weatherForecast == WeatherForecast.WIND) {
            if (pokemon.getType() == TypeEnum.EARTH) {
                pokemon.setDamage(pokemon.getDamage() +5);
            } else if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() -3);
            } else if (pokemon.getType() == TypeEnum.GRASS) {
                pokemon.setDamage(pokemon.getDamage() +4);
            } else if (pokemon.getType() == TypeEnum.ELECTRICY) {
                pokemon.setDamage(pokemon.getDamage() -3);
            }
        }
    }
    public void applyWeatherImpact(Player player1, Player player2, WeatherForecast weatherForecast){
        for(Pokemon p : player1.getCharacter().getPokemonList()) {
            weatherImpact(weatherForecast,p);
        }
        for(Pokemon p : player2.getCharacter().getPokemonList()) {
            weatherImpact(weatherForecast,p);
        }
    }


}

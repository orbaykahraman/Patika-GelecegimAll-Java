package service;

import model.Pokemon;
import model.TypeEnum;
import model.WeatherForecast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherService {


    public void weatherImpact(WeatherForecast watherForecast, Pokemon pokemon) {
        if (watherForecast == WeatherForecast.SUN) {
            if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() * 2);
                System.out.println("Güneşli havada Ateş gücü 2 katına çıktı");
            } else if (pokemon.getType() == TypeEnum.WATER) {
                pokemon.setDamage(pokemon.getDamage() / 2);
            }

        }
        if (watherForecast == WeatherForecast.RAIN) {
            if (pokemon.getType() == TypeEnum.WATER) {
                pokemon.setDamage(pokemon.getDamage() * 2);
            } else if (pokemon.getType() == TypeEnum.ELECTRICY) {
                pokemon.setDamage(pokemon.getDamage() * 2);
            } else if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() / 2);
            }
        }

        if (watherForecast == WeatherForecast.WIND) {
            if (pokemon.getType() == TypeEnum.EARTH) {
                pokemon.setDamage(pokemon.getDamage() * 2);
            } else if (pokemon.getType() == TypeEnum.FIRE) {
                pokemon.setDamage(pokemon.getDamage() / 2);
            } else if (pokemon.getType() == TypeEnum.GRASS) {
                pokemon.setDamage(pokemon.getDamage() * 2);
            } else if (pokemon.getType() == TypeEnum.ELECTRICY) {
                pokemon.setDamage(pokemon.getDamage() / 2);
            }
        }
    }

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


}

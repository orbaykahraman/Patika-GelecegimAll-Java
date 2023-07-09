package Model;

import java.util.ArrayList;
import java.util.List;

public class Film {

    public String filmName;
    public String releaseDate;
    public String directorName;

    public double imdb;

    public List<Category> categoryList;

    public List<Platform> platformList;

    public List<String> showTimeList;


    public Film(String filmName, String releaseDate, String directorName, double imdb,
                List<Category> categoryList, List<Platform> platformList, List<String> showTimeList) {
        this.filmName = filmName;
        this.releaseDate = releaseDate;
        this.directorName = directorName;
        this.imdb = imdb;
        this.categoryList = categoryList;
        this.platformList = platformList;
        this.showTimeList = showTimeList;
    }

    public Film() {
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Platform> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<Platform> platformList) {
        this.platformList = platformList;
    }

    public List<String> getShowTimeList() {
        return showTimeList;
    }

    public void setShowTimeList(List<String> showTimeList) {
        this.showTimeList = showTimeList;
    }
}

import Model.Category;
import Model.Film;
import Model.Platform;
import Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        String inputType;

        List<Category> totalCategoryList = new ArrayList<>(); // genel kategori listesi
        List<Film> filmList = new ArrayList<>(); // genel film listesi
        Service service = new Service();

        while (true) {
            System.out.print("1-) Admin Girişi \n" +
                    "2-) Kullanıcı Girişi\n" +
                    "3-) Çıkış yap\n");
            inputType = inp.nextLine();
            if(inputType.equals("3")) {
                break;
            }

            while (inputType.equals("1")) { // ADMIN AKIŞI

                    System.out.print("Film ekleme sayfasına hoşgeldiniz.(Çıkış yapmak istiyor musunuz? (E/H)");
                    String exit = inp.nextLine();
                    if (exit.equalsIgnoreCase("E")) {
                        break;
                    }
                    /**
                     *  Döngü içerisinde yer alan listelerin her defasında tekrar
                     *  oluşturulması, böylece genel listeye atabiliriz.
                     */

                    List<Category> categoryList = new ArrayList<>(); // her filme özel kategori listesi
                    List<Platform> platformList = new ArrayList<>(); // her filme özel platform listesi
                    List<String> showTimeList = new ArrayList<>(); // her filme özel gösterim zamanı listesi

                    System.out.println();
                    while (true) { // kullanıcı q basana kadar kategoriyi input olarak alıyor.
                        System.out.print("Lütfen film türünü giriniz(çıkış için 'Q' basınız) : ");
                        String categoryName = inp.nextLine();
                        if (categoryName.equalsIgnoreCase("Q")) {
                            break;
                        } else {
                            Category category = new Category(categoryName); // category nesnesi oluşturuldu
                            category.setName(category.getName().toUpperCase());
                            categoryList.add(category);
                            // Eklenen kategori eğer genel kategori listesinde varsa ekleme.- count'u arttır.
                            service.updateCount(totalCategoryList,category);
                        }
                    }
                        System.out.print("Lütfen film adını giriniz : ");
                        String name = inp.nextLine();
                        System.out.print("Lütfen film çıkış yılını giriniz : ");
                        String releaseDate = inp.nextLine();
                        if(Integer.parseInt(releaseDate) < 1800 || Integer.parseInt(releaseDate) > 2023) {
                            System.out.println("Yamlış bir tarih girdiniz.");
                            break;
                        }
                        System.out.print("Lütfen film yönetmen ismini giriniz : ");
                        String director = inp.nextLine();
                        System.out.print("Lütfen imdb puanını giriniz (x,x şeklinde virgülle ayırarak yazınız): ");
                        double imdb = inp.nextDouble();
                        if(imdb < 0 || imdb > 10) {
                            System.out.println("Yanlış bir imdb puanı girdiniz.");
                            break;
                        }

                        inp.nextLine();
                        while (true) { // kullanıcı q basana kadar platformu input olarak alıyor.
                            System.out.print("Lütfen filmin gösterildiği platformu giriniz(çıkış için 'Q' basınız) : ");
                            String platformName = inp.nextLine();
                            if (platformName.equalsIgnoreCase("Q")) {
                                break;
                            } else {
                                Platform platform = new Platform(platformName);
                                platformList.add(platform);
                            }
                        }

                        while (true) { // kullanıcı q basana kadar gösterim zamanını input olarak alıyor.
                            System.out.print("Lütfen filmin gösterileceği zamanı giriniz(çıkış için 'Q' basınız) : ");
                            String filmShowTime = inp.nextLine();
                            if (filmShowTime.equalsIgnoreCase("Q")) {
                                break;
                            } else {
                                showTimeList.add(filmShowTime);
                            }
                        }
                        Film film = new Film(name, releaseDate, director, imdb, categoryList, platformList, showTimeList);
                        filmList.add(film);
                        System.out.println("------------------------------");

                }

                while(inputType.equals("2")) { // KULLANICI AKIŞI
                    System.out.println("Lütfen izlemek istediğiniz film kategorisini seçiniz (Çıkış için '0' basınız): ");
                    for (int i = 0; i < totalCategoryList.size(); i++) { // for döngüsü ile bütün kategorileri ekrana yazdırıyor.
                        System.out.println(i + 1 + "." + totalCategoryList.get(i).getName());
                    }
                    System.out.println("0(sıfır).ÇIKIŞ");
                    int choose = inp.nextInt();
                    inp.nextLine();
                    if(choose == 0) {
                        break;
                    }
                    Category selectedCategory = totalCategoryList.get(choose - 1); // çünkü listeler 0.indexten başladığı için 1 eksiğini alıyoruz.
                    System.out.println("--------------------------------");
                    System.out.println(selectedCategory.getName() + " kategorisinde " + selectedCategory.getCount() + " film vardır."); // count kaç film olduğunu gösrmek için
                    for (Film f : filmList) { // film listesini for döngüsüyle teker teker dönüyoruz.
                        for (Category c : f.getCategoryList()) { // her film nesnesi için kategori listesini tek tek dönüyoruz.
                            // eğer kullanıcın seçtiği kategorinin adıyla film listesindeki herhangi bir filmin kategori listesindeki
                            // kategori adı eşleşirse filmin özelliklerini yazdır.
                            if (c.getName().equalsIgnoreCase(selectedCategory.getName())) { // Filmi ekrana yazdırma akışı
                                System.out.println("Film ismi : " + f.getFilmName());
                                System.out.println("Filmin çıkış tarihi : " + f.getReleaseDate());
                                System.out.println("Filmin yönetmeni : " + f.getDirectorName());
                                System.out.println("Filmin imdb puanı : " + f.getImdb());
                                System.out.print("Platformlar: ");
                                for (Platform p : f.getPlatformList()) {
                                    System.out.print(p.getName() + ",");
                                }
                                System.out.println();
                                System.out.print("Gösterim zamanları : ");
                                for (String s : f.getShowTimeList()) {
                                    System.out.print(s + ",");
                                }
                                System.out.println();
                                System.out.print("Kategori listesi : ");
                                for (Category category : f.getCategoryList()) {
                                    System.out.print(category.getName() + ",");
                                }
                                System.out.println();
                            }
                        }
                        System.out.println("------------------------------");
                    }

                }


        }

    }
}
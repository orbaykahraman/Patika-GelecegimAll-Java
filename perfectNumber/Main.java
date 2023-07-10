import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            Scanner inp = new Scanner(System.in);

            System.out.print("Bir sayı giriniz :");
            int x = inp.nextInt();

            int y = 0;

            for (int i = 1; i < x; i++){
                if (x % i == 0){
                    y += i;
                }
            } if (y == x){
                System.out.println( x + " Mükemmel sayıdır");
            } else {
                System.out.println(x + " Mükemmel sayı değildir");
            }


        }
    }

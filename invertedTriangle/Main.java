import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.print("Bir sayı giriniz :");
        int x = inp.nextInt();


        for (int k = x; k >= 1; k--){
            for (int j = 0; j < x - k ; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * k - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

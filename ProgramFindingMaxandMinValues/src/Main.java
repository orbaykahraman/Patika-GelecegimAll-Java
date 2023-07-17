import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};
        Scanner inp = new Scanner(System.in);

        System.out.print("Bir sayı giriniz :");
        int x = inp.nextInt();

        System.out.println("Dizimiz : " + Arrays.toString(list));
        Arrays.sort(list);
        int closeMax = 0, closeMin = 0;

        for (int i : list) {
            if (x < i) {
                closeMax = i;
                System.out.println("Girilen sayıdan büyük en yakın sayı :" + closeMax);
                break;
            }
        }
        for (int i = list.length - 1; i > 0; i--) {
            if (x > list[i]) {
                closeMin = list[i];
                System.out.println("Girilen sayıdan küçük en yakın sayı :" + closeMin);
                break;

            }
        }
    }
}



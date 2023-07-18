import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Dizinin boyutunu giriniz :");
        int n = inp.nextInt();
        int[] list = new int[n];

        System.out.println("Dizinin elemanlarını giriniz :");
        for (int i =0; i < n; n++){
            System.out.println((i+1) + ". Eleman: ");
            list[i]= inp.nextInt();
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
    }
}
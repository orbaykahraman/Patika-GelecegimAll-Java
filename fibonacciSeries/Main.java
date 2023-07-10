import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.print("Bir sayı ghiriniz :");
        int x = inp.nextInt();

        int n1 = 0, n2 = 1, total;

        System.out.print(x + "Sayının fibonacci serisi ile karşılığı :");
        for (int i = 1; i <= x; i++) {
            System.out.print(n1 + ",");
            total = n1 + n2;
            n1 = n2;
            n2 = total;
        }


    }
}
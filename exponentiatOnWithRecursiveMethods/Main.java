import java.util.Scanner;

public class Main {

    public static int exponentCalculation(int base, int top){
        if (top == 0){
            return 1;
        } else {
            return base * exponentCalculation(base, top -1);
        }
    }


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);


        System.out.print("Taban değerini giriniz : ");
        int x = inp.nextInt();
        System.out.print("Üs değerini giriniz :");
        int y = inp.nextInt();

        int result = exponentCalculation(x,y);

        System.out.println("Sonuç :" + result);

    }
}

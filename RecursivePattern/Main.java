import java.util.Scanner;

public class Main {

    public static void pattern(int number1, int number2, int sign){

        if(number2 > number1) return;
        if(number2 < 1) sign *= -1;
        System.out.print(" " + number2 + " ");
        pattern(number1, number2  + sign * 5, sign);
    }


    public static void main(String[] args) {


        Scanner inp = new Scanner(System.in);

        System.out.print("N sayısı :");
        int n = inp.nextInt();

        pattern(n, n, -1);



    }
}

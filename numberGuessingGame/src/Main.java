import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
       // int number = (int) (Math.random() * 100);

        Scanner inp = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;

        while (right<5){
            System.out.println("Lütfen tahmininizi giriniz :");
            selected = inp.nextInt();
            if (selected > 0 && selected < 100){
                if (selected == number){
                    System.out.println("Tebrikler doğru tahimn. Tahimn ettiğiniz sayı :" + number);
                    isWin = true;
                    break;
                } else {
                    //right++;
                    wrong[right++] = selected;
                    System.out.println("Hatalı tahmin yaptınız. Lütfen tekrar deneyiniz !");
                    System.out.println("Kalan hakkınız :" + (5-right));
                    if (selected > number){
                        System.out.println("Seçtiğiniz sayı, gizli sayıdan büyüktür.");
                    } else {
                        System.out.println("Seçtiğiniz sayı, gizli sayıdan küçüktür");
                    }
                }
            } else {
                System.out.println("0 ile 100 arasında bir değer giriniz");
            }

        }
        if (!isWin){
            System.out.print("Oyunu kaybettiniz !");
        }
        System.out.println("Tahminleriniz " + Arrays.toString(wrong));

    }
}
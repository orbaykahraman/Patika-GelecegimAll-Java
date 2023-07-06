import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        double pear, apple, banana, tomato, eggplant;

        System.out.print("How many kilos of pears :");
        pear = inp.nextDouble();
        System.out.print("How many kilos of apples :");
        apple = inp.nextDouble();
        System.out.print("How many kilos of bananas:");
        banana = inp.nextDouble();
        System.out.print("How many kilos of tomatoes :");
        tomato = inp.nextDouble();
        System.out.print("How many kilos of eggplant :");
        eggplant = inp.nextDouble();

        double pearkg = 2.14, applekg = 3.67, tomatokg = 1.11, bananakg = 0.95, eggplantkg = 5.00;

        double totalprice = (pear * pearkg) + (apple * applekg) + (banana * bananakg)
                + (tomato * tomatokg) + (eggplant * eggplantkg);

        System.out.println(totalprice);
        

    }
}

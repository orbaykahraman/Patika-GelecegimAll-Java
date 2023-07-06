import java.util.Scanner;

public class BodyMassIndexCalculator {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.print("Please enter your height (in meters):");
        double m = inp.nextDouble();

        System.out.print("Please enter your weight :");
        double kg = inp.nextDouble();

        double bodyMassIndexCalculator = kg / (m * m);

        System.out.println("Your body mass index :" + bodyMassIndexCalculator);

    }
}

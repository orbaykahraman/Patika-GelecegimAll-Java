import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter your birth year :");
         int birthDate = inp.nextInt();


         if (birthDate % 12 == 0) {
             System.out.println("Your Chinese Zodiac Sign: Monkey ");
         } else if (birthDate % 12 == 1) {
             System.out.println("Your Chinese Zodiac Sign: Rooster ");
         } else if (birthDate % 12 == 2) {
             System.out.println("Your Chinese Zodiac Sign: Dog ");
         } else if (birthDate % 12 == 3) {
             System.out.println("Your Chinese Zodiac Sign: Pig ");
         } else if (birthDate % 12 == 4) {
             System.out.println("Your Chinese Zodiac Sign: Mouse ");
         } else if (birthDate % 12 == 5) {
             System.out.println("Your Chinese Zodiac Sign: Ox ");
         } else if (birthDate % 12 == 6) {
             System.out.println("Your Chinese Zodiac Sign: Tiger ");
         } else if (birthDate % 12 == 7) {
             System.out.println("Your Chinese Zodiac Sign: Rabbit ");
         } else if (birthDate % 12 == 8) {
             System.out.println("Your Chinese Zodiac Sign: Dragon ");
         } else if (birthDate % 12 == 9) {
             System.out.println("Your Chinese Zodiac Sign: Snake ");
         } else if (birthDate % 12 == 10) {
             System.out.println("Your Chinese Zodiac Sign: Horse ");
         } else if (birthDate % 12 == 11) {
             System.out.println("Your Chinese Zodiac Sign: Sheep ");
         }

    }
}

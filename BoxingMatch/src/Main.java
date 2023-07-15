// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Orbay", 20,100,100,50);
        Fighter f2 = new Fighter("deneme",10,100,100,50);

        Match match = new Match(f1,f2,90,120);
        match.run();
    }
}
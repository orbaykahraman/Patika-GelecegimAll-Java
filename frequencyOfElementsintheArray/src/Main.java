import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {15, 23, 90, 8, 9, 15, 8, 90, 23, 15};

        Arrays.sort(array); // [8, 8, 9, 15, 15, 15, 23, 23, 90, 90]
        System.out.println(Arrays.toString(array));

        int counter = 1;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                for (int j = 0; j < array.length; j++) {
                    if ((i != j) && (array[i] == array[j])) {
                        counter++;
                    }
                }
                System.out.println(array[i] + " sayısı " + counter + " kere tekrar edildi.");
            } else if (array[i] != array[i-1]) {
                for (int j = 0; j < array.length; j++) {
                    if ((i != j) && (array[i] == array[j])) {
                        counter++;
                    }
                }
                System.out.println(array[i] + " sayısı " + counter + " kere tekrar edildi.");
            }
            counter = 1;
        }
    }
}
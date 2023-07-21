import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] list = { {2,3,4},  // 2 5
                        {5,6,4} }; // 3 6
                                    // 4 4

        System.out.println(list[1].length);
        System.out.println(list[1][0]);
        int[][] traverseArray = new int[list[1].length][list.length]; // 2 3
        int a = 0;
        int b = 0;
        int c = 1;
        for(int i=0;i < list.length;i++) {
            for(int j=0;j<list[1].length;j++) {
                if((i==0 && j==0)) {
                    traverseArray[i][j] = list[i][j];
                }
                else if(i==0){
                    traverseArray[c][0] = list[i][j];
                    c++;
                }
                else { // i1 j0, i1,j1 , i1j2
                    //    i0j1, i1j1, i2,j1
                    traverseArray[a][list.length-1] = list[i][j];
                    a++;
                }
            }
        }
        int rows = traverseArray.length;
        int columns = traverseArray[1].length;
        System.out.println("The 2D array is: ");
        for(int i=0; i < rows; i++) {
            for(int j=0; j < columns; j++)  {
                System.out.print(traverseArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
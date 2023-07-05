import java.util.*;

public class main {
    public static void main(String[] args) {

        Map<String, List<String>> students = new HashMap<>();

        List<String> students10A = new ArrayList<>(Arrays.asList("Aliyah Garrett", "Raihan Gillespie", "Edmund Andrade", "Harri Shah"));
        List<String> students11B = new ArrayList<>(Arrays.asList("Iestyn Donovan", "Jenny Martin", "Jeran Donaldson", "John Li", "Amelie Garza"));
        List<String> students9A = new ArrayList<>(Arrays.asList("Beth Hunt", "Kendan Cannon", "Lucy Bennett", "Paula Benton", "Zack Kent"));
        List<String> students10B = new ArrayList<>(Arrays.asList("Connie Gross", "Felix Hodge", "Jan Potter", "Hakan Aksoy", "Kaan Polat", "Duyan Duygusuz"));

        students.put("10A", students10A);
        students.put("11B", students11B);
        students.put("9A", students9A);
        students.put("10B", students10B);

        for (Map.Entry<String, List<String>> entry : students.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {

                String s = entry.getValue().get(i);
                String[] sArr = s.split(" ");
                s = sArr[0];
                if (s.substring(s.length() - 2).equalsIgnoreCase("an")) {
                    System.out.println(s);
                }
            }
            System.out.println("------------------------------");
        }


    }
}

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> book = new TreeSet<>();

        book.add(new Book("Sefiller",1724,"Victor Hugo","1862"));
        book.add(new Book("Bir İdam Mahkûmunun Son Günü",116,"Victor Hugo","1829"));
        book.add(new Book("Notre Dame'ın Kamburu",174,"Victor Hugo","1831"));
        book.add(new Book("1793 Devrimi",576,"Victor Hugo","1874"));
        book.add(new Book("Deniz İşçileri",464,"Victor Hugo","1866"));


        for (Book b: book){
            System.out.println(b.getName());
        }

    }
}

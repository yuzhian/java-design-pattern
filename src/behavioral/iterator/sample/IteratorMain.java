package behavioral.iterator.sample;

public class IteratorMain {
    public static void main(String[] args) {
        Aggregate aggregate = new BookShelf(4) {{
            appendBook(new Book("Around the World in 80 Days"));
            appendBook(new Book("Bible"));
            appendBook(new Book("Cinderella"));
            appendBook(new Book("Daddy-Long-Legs"));
        }};
        for (Iterator it = aggregate.iterator(); it.hasNext(); ) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}

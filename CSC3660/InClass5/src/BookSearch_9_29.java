import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BookSearch_9_29 {
    public static void main(String[] args) {
        HashMap<String, Book> books = getBooksFromSomewhere();
        String uAuth = getUserInput(books.keySet());
        System.out.printf("\nuAuth: %s", uAuth);
        Book b = books.get(uAuth);
        System.out.printf("\nBook: %s", b.toString());

        HashMap<String, ArrayList<Book>> moreBooks = new HashMap<>();
    }

    private static String getUserInput(Set<String> authSet) {
        Scanner scan = new Scanner(System.in);
        String authors = authSet.toString();
        String uIn = null;
        boolean gotOne = false;
        while(!gotOne){
            System.out.printf("\nEnter valid author %s -> ", authors);
            uIn = scan.nextLine();
            if (!authSet.contains(uIn)){
                System.out.printf("\nHey that no good! (%s)", uIn);
            }else {
                gotOne = true;
            }
        }
        return uIn;
    }

    private static HashMap<String,Book> getBooksFromSomewhere() {
        HashMap<String, Book> books = new HashMap<>();

        Book b = new Book( "The Hobbit", "Tolken", "Fiction", 1937, 5 );
        books.put( "Tolken",b);
        books.put( "Tolken",new Book( "The Fellowship of the Ring", "Tolken", "Fiction", 1954, 5 ));
        books.put( "Tolken",new Book( "The Two Towers", "Tolken", "Fiction", 1966, 5 ));
        books.put( "Tolken",new Book( "The Return of the King", "Tolken", "Fiction", 1966, 5 ));
        books.put( "Hawking", new Book("Brief History of Time", "Hawking", "NonFiction", 1988, 5));
        books.put( "Orwell", new Book("1984", "Orwell", "Fiction", 1948, 4.7));
        books.put( "Orwell", new Book("Animal Farm", "Orwell", "Fiction", 1944, 4.7));
        books.put( "Heller", new Book("Catch-22", "Heller", "Fiction", 1922, 4.3));
        books.put( "Tolstoy", new Book("Anna Karenina", "Tolstoy", "Fiction", 1878, 4.3));
        books.put( "Tolstoy", new Book("War and Peace", "Tolstoy", "Fiction", 1865, 5));
        books.put( "Tolstoy", new Book("A Confession", "Tolstoy", "Fiction", 1882, 5));
        books.put( "Carnegie", new Book("How to Win Friends and Influence People", "Carnegi", "NonFiction", 1936, 4.3));
        books.put( "Levitt", new Book("Freakonomics", "Levitt", "NonFiction", 2005, 4.9));
        books.put( "Levitt", new Book("Super Freakonomics", "Levitt", "NonFiction", 2009, 4.9));
        books.put( "Levitt", new Book("Think like a freak", "Levitt", "NonFiction", 2014, 4.9));
        books.put("Gray", new Book("Gray's Anatomy", "Gray", "Reference", 1858, 3.0));
        books.put("Rowe", new Book("Dirty Jobs", "Rowe", "Nonfiction", 2020, 4.9));
        return books;
    }
}
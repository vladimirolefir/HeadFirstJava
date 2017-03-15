class Book implements Comparable {
    String title;

    public Book(String t) {
        title = t;
    }

    public int compareTo(Object b) {
        Book book = (Book) b;
        return (title.compareTo(book.title));
    }
}

public class BookCompare implements Comparator<Book> {
    public int compare(Book one, Book two) {
        return (one.title.compareTo(two.title));
    }
}

/*
To use a TreeSet, one of these things must be true:
- The elements in the list must be of a type that implements Comparable.
- You use the TreeSet’s overloaded constructor that takes a Comparator
 */
class TestTreeSet {
    public static void main(String[] args) {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");
        BookCompare bCompare = new BookCompare();
        TreeSet<Book> tree = new TreeSet<Book>(bCompare);
        tree.add(new Book("How Cats Work");
        tree.add(new Book("Finding Emo");
        tree.add(new Book("Remix your Body");
    } System.out.println(tree);
}
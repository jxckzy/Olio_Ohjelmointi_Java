import java.util.ArrayList;


class Book_Task1 {
    private String title;
    private String author;
    private int publicationYear;

    public Book_Task1(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}


public class Library_Task1 {
    private ArrayList<Book_Task1> books = new ArrayList<>();

    // Menetelmä kirjan lisäämiseksi kirjastoon
    public void addBook(Book_Task1 book) {
        books.add(book);
        System.out.println("Book added: \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    // Menetelmä kaikkien kirjaston kirjojen näyttämiseen
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("Library catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book_Task1 book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
        }
    }

    // Menetelmä kirjojen etsimiseen ja näyttämiseen tietyn tekijän mukaan
    public void findBooksByAuthor(String author) {
        ArrayList<Book_Task1> foundBooks = new ArrayList<>();

        for (Book_Task1 book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by author \"" + author + "\".");
        } else {
            System.out.println("Books by author \"" + author + "\":");
            for (Book_Task1 book : foundBooks) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
            }
        }
    }
}


class LibraryMain_Task1 {
    public static void main(String[] args) {
        // Luo kirja-olioita
        Book_Task1 book1 = new Book_Task1("Introduction to Java Programming", "John Smith", 2020);
        Book_Task1 book2 = new Book_Task1("Data Structures and Algorithms", "Jane Doe", 2018);
        Book_Task1 book3 = new Book_Task1("The Art of Fiction", "Alice Johnson", 2019);
        Book_Task1 book4 = new Book_Task1("Advanced Java Concepts", "Jane Doe", 2021);

        // Luo kirjasto-olio
        Library_Task1 library = new Library_Task1();
        // Lisää kirjat kirjastoon

        System.out.println("Adding books to library\n");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        System.out.println("\nDisplaying all books\n");
        // Näytä kaikki kirjaston kirjat
        library.displayBooks();

        System.out.println("\nSearching for books by author\n");
        // Etsi kirjoja tietyn tekijän mukaan
        library.findBooksByAuthor("Jane Doe");

        System.out.println();
        library.findBooksByAuthor("John Smith");

        System.out.println();
        library.findBooksByAuthor("Bob Wilson");
    }
}
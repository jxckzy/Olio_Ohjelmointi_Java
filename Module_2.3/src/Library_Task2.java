import java.util.ArrayList;


class Book_Task2 {
    private String title;
    private String author;
    private int publicationYear;

    public Book_Task2(String title, String author, int publicationYear) {
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


public class Library_Task2 {
    private ArrayList<Book_Task2> books = new ArrayList<>();

    public void addBook(Book_Task2 book) {
        books.add(book);
        System.out.println("Book added: \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("Library catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book_Task2 book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        ArrayList<Book_Task2> foundBooks = new ArrayList<>();

        for (Book_Task2 book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by author \"" + author + "\".");
        } else {
            System.out.println("Books by Author \"" + author + "\":");
            for (Book_Task2 book : foundBooks) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: "
                        + book.getPublicationYear());
            }
        }
    }

    // Kirjan lainaaminen. Poistaa kirjan kirjastosta otsikon perusteella
    public void borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book_Task2 borrowedBook = books.remove(i);
                System.out.println("Book borrowed: \"" + borrowedBook.getTitle() + "\" by " + borrowedBook.getAuthor());
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\".");
    }

    // Kirjan palauttaminen. Lisää kirjan takaisin kirjastoon
    public void returnBook(Book_Task2 book) {
        books.add(book);
        System.out.println("Book returned: \"" + book.getTitle() + "\" by " + book.getAuthor());
    }
}


class LibraryMain_Task2 {
    public static void main(String[] args) {

        Book_Task2 book1 = new Book_Task2("Introduction to Java Programming", "John Smith", 2020);
        Book_Task2 book2 = new Book_Task2("Data Structures and Algorithms", "Jane Doe", 2018);
        Book_Task2 book3 = new Book_Task2("The Art of Fiction", "Alice Johnson", 2019);
        Book_Task2 book4 = new Book_Task2("Advanced Java Concepts", "Jane Doe", 2021);

        Library_Task2 library = new Library_Task2();

        System.out.println("Adding books to library\n");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        System.out.println("\nDisplaying all books\n");
        library.displayBooks();

        System.out.println("\nSearching for books by author\n");
        library.findBooksByAuthor("Jane Doe");

        System.out.println();
        library.findBooksByAuthor("John Smith");

        System.out.println();
        library.findBooksByAuthor("Bob Wilson");

        System.out.println("\nBorrowing books\n");
        // Lainaa kirjoja
        library.borrowBook("Data Structures and Algorithms");
        library.borrowBook("The Art of Fiction");
        library.borrowBook("Unknown Book");

        System.out.println("\nBooks after borrowing\n");
        // Näytä kirjat lainaamisen jälkeen
        library.displayBooks();

        System.out.println("\nReturning books\n");
        // Palauta lainatut kirjat
        library.returnBook(book2);
        library.returnBook(book3);

        System.out.println("\nBooks after returning\n");
        // Näytä kirjat palauttamisen jälkeen
        library.displayBooks();
    }
}
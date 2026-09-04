import java.util.ArrayList;


class Book_Task3 {
    private String title;
    private String author;
    private int publicationYear;

    public Book_Task3(String title, String author, int publicationYear) {
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


public class Library_Task3 {
    private ArrayList<Book_Task3> books = new ArrayList<>();

    public void addBook(Book_Task3 book) {
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
            Book_Task3 book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        ArrayList<Book_Task3> foundBooks = new ArrayList<>();

        for (Book_Task3 book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by author \"" + author + "\".");
        } else {
            System.out.println("Books by author \"" + author + "\":");
            for (Book_Task3 book : foundBooks) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book_Task3 borrowedBook = books.remove(i);
                System.out.println("Book borrowed: \"" + borrowedBook.getTitle() + "\" by " + borrowedBook.getAuthor());
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\".");
    }

    public void returnBook(Book_Task3 book) {
        books.add(book);
        System.out.println("Book returned: \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    // Tarkistaa, onko tietty kirja saatavilla kirjastossa otsikon perusteella
    public boolean isBookAvailable(String title) {
        for (Book_Task3 book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
}


class LibraryMain_Task3 {
    public static void main(String[] args) {
        Book_Task3 book1 = new Book_Task3("Introduction to Java Programming", "John Smith", 2020);
        Book_Task3 book2 = new Book_Task3("Data Structures and Algorithms", "Jane Doe", 2018);
        Book_Task3 book3 = new Book_Task3("The Art of Fiction", "Alice Johnson", 2019);
        Book_Task3 book4 = new Book_Task3("Advanced Java Concepts", "Jane Doe", 2021);

        Library_Task3 library = new Library_Task3();

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
        library.borrowBook("Data Structures and Algorithms");
        library.borrowBook("The Art of Fiction");
        library.borrowBook("Unknown Book");

        System.out.println("\nBooks after borrowing\n");
        library.displayBooks();

        System.out.println("\nReturning books\n");
        library.returnBook(book2);
        library.returnBook(book3);

        System.out.println("\nBooks after returning\n");
        library.displayBooks();

        System.out.println("\nChecking book availability\n");
        String[] titlesToCheck = {
                "Data Structures and Algorithms",
                "The Art of Fiction",
                "Introduction to Java Programming",
                "Unknown Book"
        };

        for (String title : titlesToCheck) {
            if (library.isBookAvailable(title)) {
                System.out.println("Book available: \"" + title + "\"");
            } else {
                System.out.println("Book not available: \"" + title + "\"");
            }
        }

        // Lainaa kirja ja tarkista saatavuus
        System.out.println("\nBorrowing and checking availability\n");
        System.out.println("Borrowing \"Introduction to Java Programming\"...");
        library.borrowBook("Introduction to Java Programming");

        System.out.println();
        if (library.isBookAvailable("Introduction to Java Programming")) {
            System.out.println("Book is available");
        } else {
            System.out.println("Book is not available");
        }
    }
}
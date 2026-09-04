import java.util.ArrayList;

class Book_Task5 {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    public Book_Task5(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
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

    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
            System.out.println("Rating set for \"" + title + "\": " + rating + "/5.0");
        } else {
            System.out.println("Invalid rating. Please provide a rating between 0.0 and 5.0");
        }
    }

    public double getRating() {
        return rating;
    }

    public void addReview(String review) {
        reviews.add(review);
        System.out.println("Review added for \"" + title + "\"");
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public int getReviewCount() {
        return reviews.size();
    }
}


public class Library_Task5 {
    private ArrayList<Book_Task5> books = new ArrayList<>();

    public void addBook(Book_Task5 book) {
        books.add(book);
        System.out.println("Book added: \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book_Task5 book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        ArrayList<Book_Task5> foundBooks = new ArrayList<>();

        for (Book_Task5 book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by author \"" + author + "\".");
        } else {
            System.out.println("Books by Author \"" + author + "\":");
            for (Book_Task5 book : foundBooks) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book_Task5 borrowedBook = books.remove(i);
                System.out.println("Book borrowed: \"" + borrowedBook.getTitle() + "\" by " + borrowedBook.getAuthor());
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\".");
    }

    public void returnBook(Book_Task5 book) {
        books.add(book);
        System.out.println("Book returned: \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    public boolean isBookAvailable(String title) {
        for (Book_Task5 book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Laskee ja palauttaa kaikkien kirjaston kirjojen keskimääräisen arvosanan
    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (Book_Task5 book : books) {
            totalRating += book.getRating();
        }

        return totalRating / books.size();
    }

    // Palauttaa kirjan, jolla on eniten arvosteluja
    public Book_Task5 getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        Book_Task5 mostReviewedBook = books.get(0);
        for (Book_Task5 book : books) {
            if (book.getReviewCount() > mostReviewedBook.getReviewCount()) {
                mostReviewedBook = book;
            }
        }

        return mostReviewedBook;
    }
}


class LibraryMain_Task5 {
    public static void main(String[] args) {
        Book_Task5 book1 = new Book_Task5("Introduction to Java Programming", "John Smith", 2020);
        Book_Task5 book2 = new Book_Task5("Data Structures and Algorithms", "Jane Doe", 2018);
        Book_Task5 book3 = new Book_Task5("The Art of Fiction", "Alice Johnson", 2019);
        Book_Task5 book4 = new Book_Task5("Advanced Java Concepts", "Jane Doe", 2021);

        Library_Task5 library = new Library_Task5();

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

        System.out.println("\nBorrowing and checking availability\n");
        System.out.println("Borrowing \"Introduction to Java Programming\"...");
        library.borrowBook("Introduction to Java Programming");

        System.out.println();
        if (library.isBookAvailable("Introduction to Java Programming")) {
            System.out.println("Book is available");
        } else {
            System.out.println("Book is not available");
        }

        System.out.println("\nAdding ratings and reviews\n");
        // Aseta arvosanoja
        book1.setRating(4.5);
        book2.setRating(4.8);
        book3.setRating(4.2);
        book4.setRating(4.9);

        System.out.println();
        // Lisää arvosteluja
        book1.addReview("Excellent introduction to Java programming!");
        book1.addReview("Very comprehensive and easy to follow.");

        book2.addReview("Best book on data structures I've read.");
        book2.addReview("Clear explanations with great examples.");
        book2.addReview("Highly recommended for all programmers.");

        book3.addReview("Engaging and thought-provoking.");

        System.out.println("\nLibrary statistics\n");
        // Laske ja näytä keskimääräinen arvosana
        double averageRating = library.getAverageBookRating();
        System.out.println("Average book Rating: " + String.format("%.2f", averageRating) + "/5.0");

        System.out.println();
        // Etsi ja näytä eniten arvostelluin kirja
        Book_Task5 mostReviewed = library.getMostReviewedBook();
        if (mostReviewed != null) {
            System.out.println("Most reviewed book:");
            System.out.println("Title: \"" + mostReviewed.getTitle() + "\"");
            System.out.println("Author: " + mostReviewed.getAuthor());
            System.out.println("Number of reviews: " + mostReviewed.getReviewCount());
            System.out.println("Rating: " + mostReviewed.getRating() + "/5.0");
        } else {
            System.out.println("No books in the library.");
        }
    }
}
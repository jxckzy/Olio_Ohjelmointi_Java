import java.util.ArrayList;
import java.util.List;


class Book_Task6 {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    public Book_Task6(String title, String author, int publicationYear) {
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


class User {
    private String name;
    private int age;
    private List<Book_Task6> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Palauttaa lainattujen kirjojen listan
    public List<Book_Task6> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Palauttaa lainattujen kirjojen lukumäärän
    public int getBorrowedBookCount() {
        return borrowedBooks.size();
    }

    // Lisää kirjan käyttäjän lainattujen kirjojen listaan
    public void borrowBook(Book_Task6 book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed \"" + book.getTitle() + "\"");
    }

    // Poistaa kirjan käyttäjän lainattujen kirjojen listasta
    public void returnBook(Book_Task6 book) {
        if (borrowedBooks.remove(book)) {
            System.out.println(name + " returned \"" + book.getTitle() + "\"");
        } else {
            System.out.println(name + " does not have \"" + book.getTitle() + "\"");
        }
    }

    // Tarkistaa, onko käyttäjällä tietty kirja lainattuna
    public boolean hasBorrowedBook(String title) {
        for (Book_Task6 book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Näyttää käyttäjän kaikki lainatut kirjat
    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                Book_Task6 book = borrowedBooks.get(i);
                System.out.println((i + 1) + ". \"" + book.getTitle() + "\" by " + book.getAuthor());
            }
        }
    }
}


public class Library_Task6 {
    private List<Book_Task6> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book_Task6 book) {
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
            Book_Task6 book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \""
                    + book.getAuthor() + "\", Year: " + book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        ArrayList<Book_Task6> foundBooks = new ArrayList<>();

        for (Book_Task6 book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by author \"" + author + "\".");
        } else {
            System.out.println("Books by Author \"" + author + "\":");
            for (Book_Task6 book : foundBooks) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book_Task6 borrowedBook = books.remove(i);
                System.out.println("Book borrowed: \"" + borrowedBook.getTitle() + "\" by " + borrowedBook.getAuthor());
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\".");
    }

    public void returnBook(Book_Task6 book) {
        books.add(book);
        System.out.println("Book returned: \"" + book.getTitle() + "\" by "
                + book.getAuthor());
    }

    public boolean isBookAvailable(String title) {
        for (Book_Task6 book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (Book_Task6 book : books) {
            totalRating += book.getRating();
        }

        return totalRating / books.size();
    }

    public Book_Task6 getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        Book_Task6 mostReviewedBook = books.get(0);
        for (Book_Task6 book : books) {
            if (book.getReviewCount() > mostReviewedBook.getReviewCount()) {
                mostReviewedBook = book;
            }
        }

        return mostReviewedBook;
    }

    // Lisää käyttäjän kirjastoon
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName() + " (Age: " + user.getAge() + ")");
    }

    // Poistaa käyttäjän kirjastosta
    public void removeUser(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equalsIgnoreCase(userName)) {
                User removedUser = users.remove(i);
                System.out.println("User removed: " + removedUser.getName());
                return;
            }
        }
        System.out.println("User not found: " + userName);
    }

    // Etsii käyttäjän nimen perusteella
    public User findUser(String userName) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }

    // Näyttää kaikki kirjastoon rekisteröidyt käyttäjät
    public void listAllUsers() {
        System.out.println("Registered Users:");
        if (users.isEmpty()) {
            System.out.println("No users registered");
        } else {
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                System.out.println((i + 1) + ". " + user.getName() + " (Age: " + user.getAge() + ", Borrowed Books: " + user.getBorrowedBookCount() + ")");
            }
        }
    }

    // Käyttäjä lainaa kirjan kirjastosta
    public void borrowBookByUser(String userName, String bookTitle) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found: " + userName);
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(bookTitle)) {
                Book_Task6 book = books.remove(i);
                user.borrowBook(book);
                return;
            }
        }
        System.out.println("Book not found: \"" + bookTitle + "\"");
    }

    // Käyttäjä palauttaa kirjan kirjastoon
    public void returnBookByUser(String userName, String bookTitle) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found: " + userName);
            return;
        }

        for (Book_Task6 book : user.getBorrowedBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                user.returnBook(book);
                books.add(book);
                return;
            }
        }
        System.out.println("User " + userName + " has not borrowed \"" + bookTitle + "\"");
    }

    // Näyttää tietyn käyttäjän lainatut kirjat
    public void displayUserBorrowedBooks(String userName) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found: " + userName);
            return;
        }
        user.displayBorrowedBooks();
    }
}


class LibraryMain_Task6 {
    public static void main(String[] args) {
        Book_Task6 book1 = new Book_Task6("Introduction to Java Programming", "John Smith", 2020);
        Book_Task6 book2 = new Book_Task6("Data Structures and Algorithms", "Jane Doe", 2018);
        Book_Task6 book3 = new Book_Task6("The Art of Fiction", "Alice Johnson", 2019);
        Book_Task6 book4 = new Book_Task6("Advanced Java Concepts", "Jane Doe", 2021);

        Library_Task6 library = new Library_Task6();

        System.out.println("Adding books to library\n");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        System.out.println("\nCreating users\n");
        // Luo käyttäjät
        User user1 = new User("Alice", 25);
        User user2 = new User("Bob", 30);
        User user3 = new User("Charlie", 22);

        System.out.println();
        // Lisää käyttäjät kirjastoon
        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);

        System.out.println("\nListing all users\n");
        // Näytä kaikki käyttäjät
        library.listAllUsers();

        System.out.println("\nUsers borrowing books\n");
        // Käyttäjät lainaavat kirjoja
        library.borrowBookByUser("Alice", "Introduction to Java Programming");
        library.borrowBookByUser("Alice", "The Art of Fiction");
        library.borrowBookByUser("Bob", "Data Structures and Algorithms");
        library.borrowBookByUser("Charlie", "Advanced Java Concepts");
        library.borrowBookByUser("Charlie", "Data Structures and Algorithms");

        System.out.println("\nUsers after borrowing\n");
        // Näytä käyttäjät ja heidän lainattujen kirjojen määrä
        library.listAllUsers();

        System.out.println("\nAlice's borrowed books\n");
        // Näytä Alicen lainatut kirjat
        library.displayUserBorrowedBooks("Alice");

        System.out.println();
        // Bob
        library.displayUserBorrowedBooks("Bob");

        System.out.println();
        // Charlie
        library.displayUserBorrowedBooks("Charlie");

        System.out.println("\nLibrary catalog after borrowing\n");
        // Näytä kirjastoluettelo lainaamisen jälkeen
        library.displayBooks();

        System.out.println("\nReturning books\n");
        // Käyttäjät palauttavat kirjoja
        library.returnBookByUser("Alice", "Introduction to Java Programming");
        library.returnBookByUser("Bob", "Data Structures and Algorithms");
        library.returnBookByUser("Charlie", "Advanced Java Concepts");

        System.out.println("\nUsers after returning\n");
        // Näytä käyttäjät palautuksen jälkeen
        library.listAllUsers();

        System.out.println("\nLibrary catalog after returning\n");
        // Näytä kirjastoluettelo palautuksen jälkeen
        library.displayBooks();

        System.out.println("\nFinding specific user\n");
        // Etsi tietty käyttäjä
        User foundUser = library.findUser("Alice");
        if (foundUser != null) {
            System.out.println("Found user: " + foundUser.getName() + " (Age: " + foundUser.getAge() + ")");
        }

        System.out.println();
        foundUser = library.findUser("David");
        if (foundUser == null) {
            System.out.println("User \"David\" not found in the library");
        }

        System.out.println("\nRemoving user\n");
        // Poista käyttäjä
        library.removeUser("Charlie");

        System.out.println();
        // Näytä käyttäjät poistetun käyttäjän jälkeen
        library.listAllUsers();
    }
}
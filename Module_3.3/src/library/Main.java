package library;

import library.model.*;
import library.system.Library;

public class Main {
    public static void main(String[] args) {
        // Basic library functions (Task 2)
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");
        Book book3 = new Book("1984", "George Orwell", "ISBN003");

        LibraryMember member1 = new LibraryMember("Alice", 101);
        LibraryMember member2 = new LibraryMember("Bob", 102);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println();

        library.addMember(member1);
        library.addMember(member2);

        System.out.println();

        library.displayStatus();

        System.out.println();

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);
        library.borrowBook(member1, book3);

        System.out.println();

        library.displayStatus();

        System.out.println();

        System.out.println(member1.getName() + " borrowed books: " + member1.getBorrowedBooks());
        System.out.println(member2.getName() + " borrowed books: " + member2.getBorrowedBooks());

        System.out.println();

        library.returnBook(member1, book1);
        library.returnBook(member2, book2);

        System.out.println();

        library.displayStatus();

        System.out.println();

        System.out.println(member1.getName() + " borrowed books: " + member1.getBorrowedBooks());
        System.out.println(member2.getName() + " borrowed books: " + member2.getBorrowedBooks());

        // Book reservation functions (Task 3)
        System.out.println("\nBook Reservation\n");

        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "ISBN004");
        library.addBook(book4);

        System.out.println();

        library.reserveBook(member1, book3);
        library.reserveBook(member2, book1);

        System.out.println();

        library.displayReservedBooks(member1);
        library.displayReservedBooks(member2);

        System.out.println();

        library.displayAllReservedBooks();

        System.out.println();

        library.cancelReservation(member1, book3);

        System.out.println();

        library.displayReservedBooks(member1);
        library.displayAllReservedBooks();
    }
}
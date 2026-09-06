package library.system;

import library.model.Book;
import library.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book)) {
            books.remove(book);
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available: " + book.getTitle());
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            books.add(book);
            System.out.println(member.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println(member.getName() + " does not have this book.");
        }
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!books.contains(book) && !book.isReserved()) {
            book.setReserved(true);
            book.setReservedBy(member);
            member.reserveBook(book);
            System.out.println(member.getName() + " reserved: " + book.getTitle());
        } else if (book.isReserved()) {
            System.out.println("Book already reserved: " + book.getTitle());
        } else {
            System.out.println("Book is available for borrowing: " + book.getTitle());
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (member.getReservedBooks().contains(book)) {
            book.setReserved(false);
            book.setReservedBy(null);
            member.cancelReservation(book);
            System.out.println(member.getName() + " cancelled reservation: " + book.getTitle());
        } else {
            System.out.println(member.getName() + " does not have this book reserved.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("\n" + member.getName() + "'s reserved books:");
        if (member.getReservedBooks().isEmpty()) {
            System.out.println("No reserved books");
        } else {
            for (Book book : member.getReservedBooks()) {
                System.out.println(" - " + book.getTitle());
            }
        }
    }

    public void displayAllReservedBooks() {
        System.out.println("\nAll reserved books");
        int count = 0;
        for (LibraryMember member : members) {
            for (Book book : member.getReservedBooks()) {
                System.out.println(book.getTitle() + " (Reserved by: " + member.getName() + ")");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No books are currently reserved.");
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public void displayStatus() {
        System.out.println("\nLibrary status");
        System.out.println("Total books available: " + books.size());
        System.out.println("Total members: " + members.size());
    }
}
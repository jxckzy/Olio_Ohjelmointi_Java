package library.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean reserved;
    private LibraryMember reservedBy;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public boolean isReserved() {
        return reserved;
    }

    public LibraryMember getReservedBy() {
        return reservedBy;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setReservedBy(LibraryMember reservedBy) {
        this.reservedBy = reservedBy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", reserved=" + reserved +
                '}';
    }
}
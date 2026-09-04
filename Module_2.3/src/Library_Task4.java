import java.util.ArrayList;

class Book_Task4 {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    // Konstruktori
    public Book_Task4(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
    }

    // Getter-metodit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Asettaa kirjan arvosanan
    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
            System.out.println("Rating set for \"" + title + "\": " + rating + "/5.0");
        } else {
            System.out.println("Invalid rating. Please provide a rating between 0.0 and 5.0");
        }
    }

    // Palauttaa kirjan arvosanan
    public double getRating() {
        return rating;
    }

    // Lisää arvostelun kirjalle
    public void addReview(String review) {
        reviews.add(review);
        System.out.println("Review added for \"" + title + "\"");
    }

    // Palauttaa kaikki arvostelut
    public ArrayList<String> getReviews() {
        return reviews;
    }

    // Palauttaa arvostelujen lukumäärän
    public int getReviewCount() {
        return reviews.size();
    }
}
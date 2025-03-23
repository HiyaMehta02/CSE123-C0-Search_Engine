import java.util.*;
import java.io.*;

/**
 * Hiya Mehta
 * 01/12/2025
 * CSE 123
 * Book Class Implementation
 * TA: Hayden Feeney
 * 
 * This class represents a Book object that implements the Media interface.
 * It stores the title, authors, content, and ratings of the book. The class
 * provides methods to manage ratings, retrieve book metadata, and save its
 * content for further use. This class also implements the Comparable interface
 * for comparing books.
 */
public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private Scanner content;
    private List<Integer> ratings;
    private List<String> fileContent;

    // Behavior: Creates a Book object with a title, authors, and content,
    // and initializes its attributes.
    // Exceptions: Throws IllegalArgumentException if the title is null or empty,
    // if the authors list is null or empty, or if the content is null.
    // Returns: None.
    // Parameters:
    // - title: The title of the book (String).
    // - authors: A list of authors of the book (List<String>).
    // - content: A Scanner object providing the content of the book (Scanner).
    public Book(String title, List<String> authors, Scanner content) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (authors == null || authors.isEmpty()) {
            throw new IllegalArgumentException("Authors list cannot be null or empty.");
        }
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null.");
        }
        this.title = title;
        this.authors = authors;
        this.content = content;
        this.fileContent = new ArrayList<String>();
        while (content.hasNext()) {
            this.fileContent.add(content.next());
        }
        this.ratings = new ArrayList<Integer>();
    }

    // Behavior: Retrieves the title of the book.
    // Exceptions: None.
    // Returns: The title of the book (String).
    // Parameters: None.
    public String getTitle() {
        return this.title;
    }

    // Behavior: Retrieves the list of authors of the book.
    // Exceptions: None.
    // Returns: A list of authors (List<String>).
    // Parameters: None.
    public List<String> getArtists() {
        return this.authors;
    }

    // Behavior: Adds a rating to the book if the score is non-negative.
    // Exceptions: Throws IllegalArgumentException if the score is negative.
    // Returns: None.
    // Parameters: An integer score representing the rating to be added.
    public void addRating(int score) {
        if (score >= 0) {
            Integer newRating = score;
            ratings.add(newRating);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Behavior: Returns the number of ratings the book has received.
    // Exceptions: None.
    // Returns: The number of ratings as an integer.
    // Parameters: None.
    public int getNumRatings() {
        return ratings.size();
    }

    // Behavior: Calculates and returns the average rating of the book. If no
    // ratings
    // exist, returns 0.0.
    // Exceptions: None.
    // Returns: The average rating as a double.
    // Parameters: None.
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double size = ratings.size();
        double averageRating = 0;
        for (Integer rating : ratings) {
            averageRating += rating;
        }
        averageRating = averageRating / size;
        return averageRating;
    }

    // Behavior: Returns the list of content (words) in the book.
    // Exceptions: None.
    // Returns: A list of strings representing the content of the book.
    // Parameters: None.
    public List<String> getContent() {
        return fileContent;
    }

    // Behavior: Returns a string representation of the book, including the title,
    // authors, average rating, and number of ratings.
    // Exceptions: None.
    // Returns: A string describing the book's title, authors, and ratings
    // information.
    // Parameters: None.
    public String toString() {
        if (ratings.size() == 0) {
            return title + " by " + authors.toString();
        } else {
            String averageRating = String.format("%.2f", getAverageRating());
            return title + " by " + authors.toString() + ": " + averageRating +
                    " (" + getNumRatings() + " ratings)";
        }
    }

    // Behavior: Compares this book's average rating to another book's average
    // rating and returns a comparison value.
    // Exceptions: None.
    // Returns: A negative integer if this book's rating is lower, a positive
    // integer if it's higher, or zero if they are equal.
    // Parameters: otherBook - The book to compare this book with.
    public int compareTo(Book otherBook) {
        double thisRating = this.getAverageRating();
        double otherRating = otherBook.getAverageRating();
        return (int) (otherRating - thisRating);
    }
}
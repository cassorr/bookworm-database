package App.Domain;

public class Book {
    private int bookID;          // Corresponds to Book_ID in the database
    private String title;        // Title of the book
    private String publicationDate; // Publication date of the book

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }
}

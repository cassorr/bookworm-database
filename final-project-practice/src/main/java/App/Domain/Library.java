package App.Domain;

import java.util.List;

public class Library {
    private int libraryID; // Corresponds to Library_ID in the database
    private int userID;    // Foreign key referencing User_ID
    private List<LibraryBook> books; // List of books in the library

    // Getters and Setters
    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<LibraryBook> getBooks() {
        return books;
    }

    public void setBooks(List<LibraryBook> books) {
        this.books = books;
    }

    // toString() for debugging and logging
    @Override
    public String toString() {
        return "Library{" +
                "libraryID=" + libraryID +
                ", userID=" + userID +
                ", books=" + books +
                '}';
    }
}

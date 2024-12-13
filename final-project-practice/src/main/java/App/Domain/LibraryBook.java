package App.Domain;

public class LibraryBook {
    private int libraryID;     // Corresponds to Library_ID in LIBRARY_BOOK table
    private int bookID;        // Corresponds to Book_ID in LIBRARY_BOOK table
    private String bookStatus; // Corresponds to Book_Status in LIBRARY_BOOK table

    // Getters and Setters
    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    // toString() for debugging and logging
    @Override
    public String toString() {
        return "LibraryBook{" +
                "libraryID=" + libraryID +
                ", bookID=" + bookID +
                ", bookStatus='" + bookStatus + '\'' +
                '}';
    }
}

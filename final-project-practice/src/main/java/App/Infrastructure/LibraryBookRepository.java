package App.Infrastructure;

import App.Domain.LibraryBook;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LibraryBookRepository {
    private final JdbcTemplate databaseConnection;

    public LibraryBookRepository(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Get all library books
    public List<LibraryBook> getAll() {
        String SQL = "SELECT Library_ID AS libraryID, Book_ID AS bookID, Book_Status AS bookStatus FROM LIBRARY_BOOK;";
        return this.databaseConnection.query(SQL, BeanPropertyRowMapper.newInstance(LibraryBook.class));
    }

    // Get all books in a specific library
    public List<LibraryBook> getBooksByLibraryID(int libraryID) {
        String SQL = "SELECT Library_ID AS libraryID, Book_ID AS bookID, Book_Status AS bookStatus FROM LIBRARY_BOOK WHERE Library_ID = ?;";
        return this.databaseConnection.query(SQL, BeanPropertyRowMapper.newInstance(LibraryBook.class), libraryID);
    }

    // Add a book to a library
    public void addBookToLibrary(LibraryBook libraryBook) {
        String SQL = "INSERT INTO LIBRARY_BOOK (Library_ID, Book_ID, Book_Status) VALUES (?, ?, ?);";
        this.databaseConnection.update(SQL, libraryBook.getLibraryID(), libraryBook.getBookID(), libraryBook.getBookStatus());
    }

    // Update a book's status in a library
    public void updateBookStatus(int libraryID, int bookID, String bookStatus) {
        String SQL = "UPDATE LIBRARY_BOOK SET Book_Status = ? WHERE Library_ID = ? AND Book_ID = ?;";
        this.databaseConnection.update(SQL, bookStatus, libraryID, bookID);
    }

    // Remove a book from a library
    public void removeBookFromLibrary(int libraryID, int bookID) {
        String SQL = "DELETE FROM LIBRARY_BOOK WHERE Library_ID = ? AND Book_ID = ?;";
        this.databaseConnection.update(SQL, libraryID, bookID);
    }
}

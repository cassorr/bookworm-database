package App.Infrastructure;

import App.Domain.Library;
import App.Domain.LibraryBook;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LibraryRepository extends BaseRepository<Library> {

    public LibraryRepository(JdbcTemplate databaseConnection) {
        super(databaseConnection);
    }

    // Get all libraries
    @Override
    public List<Library> get() {
        String SQL = "SELECT Library_ID AS libraryID, User_ID AS userID FROM LIBRARY;";
        return this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(Library.class));
    }

    // Get a single library by ID
    @Override
    public Library get(String id) throws Exception {
        String SQL = "SELECT Library_ID AS libraryID, User_ID AS userID FROM LIBRARY WHERE Library_ID = ?;";
        List<Library> libraries = this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(Library.class), id);

        if (libraries.isEmpty()) {
            throw new Exception("Library not found with ID: " + id);
        }

        Library library = libraries.get(0);

        // Fetch books in the library
        String booksSQL = "SELECT Library_ID AS libraryID, Book_ID AS bookID, Book_Status AS bookStatus " +
                "FROM LIBRARY_BOOK WHERE Library_ID = ?;";
        List<LibraryBook> books = this.getDatabaseConnection().query(booksSQL, BeanPropertyRowMapper.newInstance(LibraryBook.class), id);
        library.setBooks(books);

        return library;
    }

    // Create a new library
    @Override
    public void create(Library library) {
        String SQL = "INSERT INTO LIBRARY (User_ID) VALUES (?);";
        this.getDatabaseConnection().update(SQL, library.getUserID());
    }

    // Delete a library by ID
    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM LIBRARY WHERE Library_ID = ?;";
        this.getDatabaseConnection().update(SQL, id);
    }

    // Update a library (not typically needed, so optional)
    @Override
    public void update(String id, Library library) {
        throw new UnsupportedOperationException("Update not supported for Library.");
    }

    // Add a book to a library
    public void addBookToLibrary(int libraryID, int bookID, String bookStatus) {
        String SQL = "INSERT INTO LIBRARY_BOOK (Library_ID, Book_ID, Book_Status) VALUES (?, ?, ?);";
        this.getDatabaseConnection().update(SQL, libraryID, bookID, bookStatus);
    }

    // Remove a book from a library
    public void removeBookFromLibrary(int libraryID, int bookID) {
        String SQL = "DELETE FROM LIBRARY_BOOK WHERE Library_ID = ? AND Book_ID = ?;";
        this.getDatabaseConnection().update(SQL, libraryID, bookID);
    }
}

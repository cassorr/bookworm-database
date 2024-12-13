package App.Infrastructure;

import App.Domain.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookRepository extends BaseRepository<Book> {

    public BookRepository(JdbcTemplate databaseConnection) {
        super(databaseConnection);
    }

    // Get all books
    @Override
    public List<Book> get() {
        String SQL = "SELECT Book_ID AS bookID, Title AS title, Publication_Date AS publicationDate FROM BOOK;";
        return this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(Book.class));
    }

    // Get a book by ID
    @Override
    public Book get(String id) throws Exception {
        String SQL = "SELECT Book_ID AS bookID, Title AS title, Publication_Date AS publicationDate " +
                "FROM BOOK WHERE Book_ID = ?;";
        List<Book> books = this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(Book.class), id);

        if (books.isEmpty()) {
            throw new Exception("Book not found with ID: " + id);
        }

        return books.get(0);
    }

    // Create a new book
    @Override
    public void create(Book book) {
        String SQL = "INSERT INTO BOOK (Title, Publication_Date) VALUES (?, ?);";
        this.getDatabaseConnection().update(SQL, book.getTitle(), book.getPublicationDate());
    }

    // Delete a book by ID
    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM BOOK WHERE Book_ID = ?;";
        this.getDatabaseConnection().update(SQL, id);
    }

    // Update a book
    @Override
    public void update(String id, Book book) {
        String SQL = "UPDATE BOOK SET Title = ?, Publication_Date = ? WHERE Book_ID = ?;";
        this.getDatabaseConnection().update(SQL, book.getTitle(), book.getPublicationDate(), id);
    }
}

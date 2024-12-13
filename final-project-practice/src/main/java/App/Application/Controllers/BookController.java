package App.Application.Controllers;

import App.Domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import App.Infrastructure.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(@Autowired JdbcTemplate databaseConnection) {
        this.bookRepository = new BookRepository(databaseConnection);
    }

    // GET: Retrieve all books
    @GetMapping("/")
    public List<Book> getBooks() {
        return this.bookRepository.get();
    }

    // GET: Retrieve a specific book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) throws Exception {
        return this.bookRepository.get(id);
    }

    // POST: Add a new book
    @PostMapping("/")
    public void createBook(@RequestBody Book book) {
        this.bookRepository.create(book);
    }

    // DELETE: Remove a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        this.bookRepository.delete(id);
    }

    // PUT: Update a book's details
    @PutMapping("/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book book) {
        this.bookRepository.update(id, book);
    }
}

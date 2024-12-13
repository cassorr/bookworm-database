package App.Application.Controllers;

import App.Domain.LibraryBook;
import App.Infrastructure.LibraryBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-books")
public class LibraryBookController {
    private final LibraryBookRepository libraryBookRepository;

    public LibraryBookController(@Autowired JdbcTemplate databaseConnection) {
        this.libraryBookRepository = new LibraryBookRepository(databaseConnection);
    }

    // GET: Retrieve all library books
    @GetMapping("/")
    public List<LibraryBook> getAllLibraryBooks() {
        return this.libraryBookRepository.getAll();
    }

    // GET: Retrieve books by Library ID
    @GetMapping("/{libraryID}")
    public List<LibraryBook> getBooksByLibraryID(@PathVariable int libraryID) {
        return this.libraryBookRepository.getBooksByLibraryID(libraryID);
    }


    // POST: Add a book to a library
    @PostMapping("/")
    public void addBookToLibrary(@RequestBody LibraryBook libraryBook) {
        this.libraryBookRepository.addBookToLibrary(libraryBook);
    }

    // PUT: Update a book's status in a library
    @PutMapping("/{libraryID}/{bookID}")
    public void updateBookStatus(@PathVariable int libraryID, @PathVariable int bookID, @RequestBody LibraryBook libraryBook) {
        this.libraryBookRepository.updateBookStatus(libraryID, bookID, libraryBook.getBookStatus());
    }

    // DELETE: Remove a book from a library
    @DeleteMapping("/{libraryID}/{bookID}")
    public void removeBookFromLibrary(@PathVariable int libraryID, @PathVariable int bookID) {
        this.libraryBookRepository.removeBookFromLibrary(libraryID, bookID);
    }
}

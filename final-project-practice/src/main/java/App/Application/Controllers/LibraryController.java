package App.Application.Controllers;

import App.Domain.Library;
import App.Domain.LibraryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import App.Infrastructure.LibraryRepository;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    private final LibraryRepository libraryRepository;

    public LibraryController(@Autowired JdbcTemplate databaseConnection) {
        this.libraryRepository = new LibraryRepository(databaseConnection);
    }

    // GET: Retrieve all libraries
    @GetMapping("/")
    public List<Library> getLibraries() {
        return this.libraryRepository.get();
    }

    // GET: Retrieve a specific library by ID
    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable String id) throws Exception {
        return this.libraryRepository.get(id);
    }

    // POST: Create a new library for a user
    @PostMapping("/")
    public void createLibrary(@RequestBody Library library) {
        this.libraryRepository.create(library);
    }

    // DELETE: Delete a library by ID
    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable String id) {
        this.libraryRepository.delete(id);
    }
}

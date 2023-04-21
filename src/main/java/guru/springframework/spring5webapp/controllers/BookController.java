package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 12/24/19.
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    // we can inject bookRepository via constructor since this is Spring managed bean (@Controller)
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // map request to method
    public String getBooks(Model model){ // MODEL will be returned to the VIEW

        // let's enhance the model (with a list of books) before returning it
        model.addAttribute("books", bookRepository.findAll());

        return "books/list"; // look for the list template inside the directory of books
    }
}

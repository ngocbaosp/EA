package server.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import server.demo.domain.Book;
import server.demo.domain.Person;
import server.demo.service.BookServiceImpl;
import server.demo.service.PersonServiceImpl;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/book/{id}")
    private Book getOne(@PathVariable Integer id, Model model) {
        return bookService.getOne(id);
    }

    @PutMapping(value = "/book/{id}")
    public void put(@PathVariable Integer id, @RequestBody Book book) {
        if (id != book.getId()) {
            throw new IllegalArgumentException();
        }
        bookService.update(book);
    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

    @RequestMapping(value = "book/redirect", method = RequestMethod.POST)
    public RedirectView post(@RequestBody Book book) {
        long id = bookService.add(book);
        return new RedirectView("/person/" + id);
    }

    @RequestMapping(value = "book/add", method = RequestMethod.POST)
    public @ResponseBody
    Integer add(@RequestBody Book book) {
        Integer id = bookService.add(book);
        return id;
    }
}

package edu.mum.cs544.book;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller

public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @PostMapping("/books")
    public String add(Book book) {
        bookService.add(book);
        //return "redirect:book/books"; error

        return "redirect:books";

    }

    @GetMapping("/books/add")
    public String viewAdd(@ModelAttribute Book car, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(Book book, @PathVariable int id) {
        bookService.update(book); // car.id already set by binding
        //return "redirect:/books"; // will get error
        return "redirect:/books";
    }

    @PostMapping(value="/books/delete")
    public String delete(int bookId) {
        bookService.delete(bookId);
        //return "redirect:/books"; // will get error
        return "redirect:/books";
    }
}

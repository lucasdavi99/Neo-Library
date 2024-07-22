package com.lucasdavi.neolibrary.controllers;

import com.lucasdavi.neolibrary.dtos.BookDTO;
import com.lucasdavi.neolibrary.models.Book;
import com.lucasdavi.neolibrary.services.book.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("bookDTO", new BookDTO("", List.of(), List.of(), "", 0, 0, null, ""));
        return "new-book";
    }

    @PostMapping("/new")
    public String newBook(@ModelAttribute @Validated BookDTO bookDTO, Model model) {
        try {
            var book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            bookService.save(book);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "new-book";
        }
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBookById(Model model, @PathVariable("id") String id) {
        Book book = bookService.findById(String.valueOf(id));
        model.addAttribute("book", book);
        return "book";
    }
}

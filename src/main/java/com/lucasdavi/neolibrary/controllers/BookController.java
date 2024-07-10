package com.lucasdavi.neolibrary.controllers;

import com.lucasdavi.neolibrary.dtos.BookDTO;
import com.lucasdavi.neolibrary.models.Book;
import com.lucasdavi.neolibrary.services.book.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Object> newBook(@RequestBody @Validated BookDTO bookDTO) {
        try {
            var book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }
}

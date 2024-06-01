package com.lucasdavi.neolibrary.controllers;

import com.lucasdavi.neolibrary.dtos.BookDTO;
import com.lucasdavi.neolibrary.models.Book;
import com.lucasdavi.neolibrary.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/newbook")
    public ResponseEntity<Object> newBook(@RequestBody @Validated BookDTO bookDTO) {
        try {
            var book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}

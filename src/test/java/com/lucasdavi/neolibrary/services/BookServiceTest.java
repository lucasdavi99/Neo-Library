package com.lucasdavi.neolibrary.services;

import com.lucasdavi.neolibrary.models.Book;
import com.lucasdavi.neolibrary.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void save() {
        Book book = new Book();
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book result = bookService.save(book);

        assertNotNull(result);
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}
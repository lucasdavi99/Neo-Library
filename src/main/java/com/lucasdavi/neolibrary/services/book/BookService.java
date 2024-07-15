package com.lucasdavi.neolibrary.services.book;

import com.lucasdavi.neolibrary.models.Book;
import com.lucasdavi.neolibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMethods bookMethods;

    @Autowired
    private BookRepository bookRepository;

    //Método para buscar todos os livros
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    //Método para buscar um livro pelo id
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    //Método para salvar um livro
    public Book save(Book book) {
        if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
            book.setIsbn(bookMethods.generateISBN());
        }
        return bookRepository.save(book);
    }

    //Método para deletar um livro
    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    //Método para atualizar um livro
    public Book update(String id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if (bookToUpdate == null) {
            return null;
        }
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setGenres(book.getGenres());
        bookToUpdate.setDescription(book.getDescription());
        bookToUpdate.setYear(book.getYear());
        bookToUpdate.setCoverImage(book.getCoverImage());
        return bookRepository.save(bookToUpdate);
    }
}

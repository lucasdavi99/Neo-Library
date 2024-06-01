package com.lucasdavi.neolibrary.repositories;

import com.lucasdavi.neolibrary.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{
}

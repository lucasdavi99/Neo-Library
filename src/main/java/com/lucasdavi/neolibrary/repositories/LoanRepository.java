package com.lucasdavi.neolibrary.repositories;

import com.lucasdavi.neolibrary.models.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<Loan, String>{
}

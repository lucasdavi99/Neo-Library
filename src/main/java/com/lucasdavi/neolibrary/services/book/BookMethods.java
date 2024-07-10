package com.lucasdavi.neolibrary.services.book;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookMethods {

    //Método para gerar um ISBN-13
    protected String generateISBN() {
        Random random = new Random();
        StringBuilder isbn = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            isbn.append(random.nextInt(10));
        }

        isbn.append(calculateCheckDigit(isbn.toString()));
        return isbn.toString();
    }

    // Método para calcular o dígito de verificação do ISBN-13
    private int calculateCheckDigit(String isbn) {
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int digit = Integer.parseInt(isbn.substring(i, i + 1));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checkDigit = 10 - (sum % 10);
        return (checkDigit == 10) ? 0 : checkDigit;
    }
}

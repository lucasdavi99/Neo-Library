package com.lucasdavi.neolibrary.dtos;

import java.util.List;

public record BookDTO(
        String title,
        List<String> authors,
        List<String> genres,
        String description,
        Integer year,
        Integer quantity,
        String isbn
){}

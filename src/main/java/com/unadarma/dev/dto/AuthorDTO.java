package com.unadarma.dev.dto;

import java.util.List;

public class AuthorDTO {
    private String name;

    private List<BookInputDTO> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookInputDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookInputDTO> books) {
        this.books = books;
    }
}

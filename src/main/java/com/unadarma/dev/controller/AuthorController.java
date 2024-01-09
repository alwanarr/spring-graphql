package com.unadarma.dev.controller;

import com.unadarma.dev.dto.AuthorDTO;
import com.unadarma.dev.dto.BookInputDTO;
import com.unadarma.dev.dto.UpdateAuthorDTO;
import com.unadarma.dev.entity.Author;
import com.unadarma.dev.entity.Book;
import com.unadarma.dev.repository.AuthorRepository;
import com.unadarma.dev.repository.BookRepository;
import com.unadarma.dev.service.AuthorService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

//    private final AuthorRepository authorRepository;
//
//    private final BookRepository bookRepository;
//
//    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Author> authors() {
       return authorService.authors();
    }

    @MutationMapping
    Author createAuthor(@Argument AuthorDTO author)
    {
        return authorService.createAuthor(author);
    }

    @MutationMapping
    Author updateAuthor(@Argument(name = "authorId") Long id,
                        @Argument(name = "updateAuthor") UpdateAuthorDTO authorDTO)
    {
        return authorService.updateAuthor(id, authorDTO);
    }
}

package com.unadarma.dev.service;

import com.unadarma.dev.dto.AuthorDTO;
import com.unadarma.dev.dto.BookInputDTO;
import com.unadarma.dev.dto.UpdateAuthorDTO;
import com.unadarma.dev.entity.Author;
import com.unadarma.dev.entity.Book;
import com.unadarma.dev.repository.AuthorRepository;
import com.unadarma.dev.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;


    public AuthorService(AuthorRepository authorRepository,
                         BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor( AuthorDTO author)
    {
        Author authorData = new Author(author.getName());


        List<Book> books = new ArrayList<>();
        if (author.getBooks() != null) {
            for (BookInputDTO bookInputDTO : author.getBooks()) {
                Book newBook = new Book(bookInputDTO.getTitle(),
                        bookInputDTO.getQty(), authorData);
                books.add(newBook);
            }
        }

        Author savedAuthor = authorRepository.save(authorData);

        authorData.setBooks(books);
        for (Book book : books) {
            book.setAuthor(savedAuthor);
        }
        bookRepository.saveAll(books);
        return savedAuthor;
    }

    public Author updateAuthor( Long id,
                         UpdateAuthorDTO authorDTO)
    {
        Author authorById = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found  "));


        authorById.setName(authorDTO.getName());
        return authorRepository.save(authorById);
    }

    public List<Author> authors() {
        return authorRepository.findAll();
    }
}

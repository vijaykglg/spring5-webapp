/*
 * Copyright (c) 2020. All rights reserved.
 * This code implemented by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework 5: Beginner to guru
 */

package com.vijay.learn.spring.spring5webapp.bootstrap;

import com.vijay.learn.spring.spring5webapp.domain.Author;
import com.vijay.learn.spring.spring5webapp.domain.Book;
import com.vijay.learn.spring.spring5webapp.domain.Publisher;
import com.vijay.learn.spring.spring5webapp.repository.AuthorRepository;
import com.vijay.learn.spring.spring5webapp.repository.BookRepository;
import com.vijay.learn.spring.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Eric", "Jhon");
        Book book = new Book("Head First Spring", "12121212");
        Publisher publisher = new Publisher("Head First", "Block1", "Mumbai", "Maharashtra", 400022);

        publisherRepository.save(publisher);

        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("Spring Framework", "54545454");

        author.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootsrap..");
        System.out.println("Number Of Books = " + bookRepository.count());
        System.out.println("Publisher Count = " + publisherRepository.count() + " Publisher Number of Books = " + publisher.getBooks().size());
    }
}

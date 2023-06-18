package br.edu.ifsc.padroes.sistema.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private static BookController instance;
    private List<Book> books;

    private BookController() {
        books = new ArrayList<>();
    }

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}


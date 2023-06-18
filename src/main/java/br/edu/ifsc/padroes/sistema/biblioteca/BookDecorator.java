package br.edu.ifsc.padroes.sistema.biblioteca;

abstract class BookDecorator implements Book {
    protected Book decoratedBook;

    public BookDecorator(Book decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    public String getTitle() {
        return decoratedBook.getTitle();
    }

    public String getDescription() {
        return decoratedBook.getDescription();
    }
}
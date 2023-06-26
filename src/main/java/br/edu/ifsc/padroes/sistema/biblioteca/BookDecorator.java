package br.edu.ifsc.padroes.sistema.biblioteca;

abstract class BookDecorator implements Book {
    protected Book decoratedBook;

    public BookDecorator(Book decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    @Override
    public String getTitle() {
        return decoratedBook.getTitle();
    }

    @Override
    public String getDescription() {
        return decoratedBook.getDescription();
    }

    @Override
    public Category getCategory() {
        return decoratedBook.getCategory();
    }
}
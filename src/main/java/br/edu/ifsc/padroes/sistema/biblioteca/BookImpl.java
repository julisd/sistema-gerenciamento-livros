package br.edu.ifsc.padroes.sistema.biblioteca;

public class BookImpl implements Book {
    private String title;
    private String description;

    public BookImpl(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

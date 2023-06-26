package br.edu.ifsc.padroes.sistema.biblioteca;

public class BookImpl implements Book {
    private String title;
    private String description;

    private Category category;


    public BookImpl(String title, String description, Category category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Category getCategory() {
        return category;
    }
}

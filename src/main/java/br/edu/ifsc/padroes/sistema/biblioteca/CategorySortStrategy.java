package br.edu.ifsc.padroes.sistema.biblioteca;

import java.util.Comparator;
import java.util.List;

public class CategorySortStrategy implements SortStrategy {

    private Category category;

    public CategorySortStrategy(Category category) {
        this.category = category;
    }
    @Override
    public void sort(List<Book> books) {
        books.sort(Comparator.comparing(book -> book.getCategory().name()));

    }
}

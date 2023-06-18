package br.edu.ifsc.padroes.sistema.biblioteca;

import java.util.List;

class TitleSortStrategy implements SortStrategy {
    public void sort(List<Book> books) {
        books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
    }
}
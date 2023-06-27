package br.edu.ifsc.padroes.sistema.biblioteca;

import java.util.Scanner;

public class BibliotecaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookController bookManager = BookController.getInstance();

        while (true) {
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Mostrar livros");
            System.out.println("4. Ordenar livros por título");
            System.out.println("5. Ordenar livros por categoria");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida!");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();
                    System.out.print("Digite a descrição do livro: ");
                    String description = scanner.nextLine();
                    System.out.println("Categorias disponíveis:");
                    for (Category category : Category.values()) {
                        System.out.println(category.ordinal() + ". " + category.name());
                    }
                    System.out.print("Digite o número da categoria do livro: ");
                    int categoryIndex;
                    if (scanner.hasNextInt()) {
                        categoryIndex = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Categoria inválida!");
                        scanner.nextLine();
                        continue;
                    }
                    if (categoryIndex >= 0 && categoryIndex < Category.values().length) {
                        Category categoryAdd = Category.values()[categoryIndex];
                        Book book = new BookImpl(title, description, categoryAdd);
                        bookManager.addBook(book);
                        System.out.println("Livro cadastrado com sucesso!");
                    } else {
                        System.out.println("Categoria inválida!");
                    }
                    break;
                case 2:
                    if (bookManager.getBooks().isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("\nLista de livros:");
                        for (int i = 0; i < bookManager.getBooks().size(); i++) {
                            Book book = bookManager.getBooks().get(i);
                            System.out.println(i + ". Título: " + book.getTitle());
                            System.out.println("   Descrição: " + book.getDescription());
                            System.out.println("   Categoria: " + book.getCategory());
                            System.out.println("------------------------");
                        }

                        System.out.print("Digite o índice do livro a ser removido: ");
                        int removeIndex;
                        if (scanner.hasNextInt()) {
                            removeIndex = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println("Índice inválido!");
                            scanner.nextLine();
                            continue;
                        }

                        if (removeIndex >= 0 && removeIndex < bookManager.getBooks().size()) {
                            Book removeBook = bookManager.getBooks().get(removeIndex);
                            bookManager.removeBook(removeBook);
                            System.out.println("Livro removido com sucesso.");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;
                case 3:
                    if (bookManager.getBooks().isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("\nLista de livros:");
                        for (Book b : bookManager.getBooks()) {
                            System.out.println("Título: " + b.getTitle());
                            System.out.println("Descrição: " + b.getDescription());
                            System.out.println("Categoria: " + b.getCategory());
                            System.out.println("------------------------");
                        }
                    }
                    break;
                case 4:
                    SortStrategy sortStrategy = new TitleSortStrategy();

                    if (bookManager.getBooks().isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        sortStrategy.sort(bookManager.getBooks());
                        System.out.println("\nLivros ordenados por título.");
                    }
                    break;
                case 5:
                    if (bookManager.getBooks().isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("Categorias disponíveis:");
                        for (Category category : Category.values()) {
                            System.out.println(category.ordinal() + ". " + category.name());
                        }
                        System.out.print("Digite o número da categoria para ordenar os livros: ");
                        int categorySortIndex;
                        if (scanner.hasNextInt()) {
                            categorySortIndex = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println("Categoria inválida!");
                            scanner.nextLine();
                            continue;
                        }
                        if (categorySortIndex >= 0 && categorySortIndex < Category.values().length) {
                            Category categorySort = Category.values()[categorySortIndex];
                            sortStrategy = new CategorySortStrategy(categorySort);
                            sortStrategy.sort(bookManager.getBooks());
                            System.out.println("\nLivros ordenados por categoria.");
                        } else {
                            System.out.println("Categoria inválida!");
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println();
        }
    }
}

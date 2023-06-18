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
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");
			int option = scanner.nextInt();

			switch (option) {
				case 1:
					System.out.print("Digite o título do livro: ");
					String title = scanner.next();
					System.out.print("Digite a descrição do livro: ");
					String description = scanner.next();
					Book book = new BookImpl(title, description);
					bookManager.addBook(book);
					break;
				case 2:
					System.out.print("Digite o índice do livro a ser removido: ");
					int removeIndex = scanner.nextInt();
					if (removeIndex >= 0 && removeIndex < bookManager.getBooks().size()) {
						Book removeBook = bookManager.getBooks().get(removeIndex);
						bookManager.removeBook(removeBook);
					} else {
						System.out.println("Índice inválido!");
					}
					break;
				case 3:
					System.out.println("\n Lista de livros:");
					for (Book b : bookManager.getBooks()) {
						System.out.println("Título: " + b.getTitle());
						System.out.println("Descrição: " + b.getDescription());
						System.out.println("------------------------");
					}
					break;
				case 4:
					SortStrategy sortStrategy = new TitleSortStrategy();
					sortStrategy.sort(bookManager.getBooks());
					System.out.println("\n Livros ordenados por título.");
					break;
				case 5:
					System.exit(0);
			}

			System.out.println();
		}
	}
}
